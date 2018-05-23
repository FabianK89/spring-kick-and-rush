package de.fmk.kicknrush.model;


import de.fmk.kicknrush.mongodb.DBConstants;
import de.fmk.kicknrush.mongodb.MatchRepository;
import de.fmk.kicknrush.mongodb.TeamRepository;
import de.fmk.kicknrush.mongodb.bean.DBGoal;
import de.fmk.kicknrush.mongodb.bean.DBLocation;
import de.fmk.kicknrush.mongodb.bean.DBMatch;
import de.fmk.kicknrush.mongodb.bean.DBMatchResult;
import de.fmk.kicknrush.mongodb.bean.DBTeam;
import de.fmk.kicknrush.mongodb.bean.UserBet;
import de.fmk.kicknrush.openligadb.OpenLigaDBConstants;
import de.fmk.kicknrush.openligadb.bean.Goal;
import de.fmk.kicknrush.openligadb.bean.Match;
import de.fmk.kicknrush.openligadb.bean.MatchResult;
import de.fmk.kicknrush.openligadb.bean.Team;
import de.fmk.kicknrush.util.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class DataHandler
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DataHandler.class);

	@Autowired
	private MatchRepository matchRepository;
	@Autowired
	private TeamRepository  teamRepository;


	public boolean hasDataForLeague(final String leagueParam)
	{
		final List<DBMatch> matches;
		final String        regEx;

		regEx = "bl1/20[0-9]{2}";

		if (leagueParam == null || !leagueParam.matches(regEx))
			throw new IllegalArgumentException("The parameter must match the regular expression '" + regEx + "'.");

		matches = matchRepository.findByLeagueParam(leagueParam);

		return matches != null && !matches.isEmpty();
	}


	public List<DBMatch> getMatchesForSeasonDay(final String seasonDay)
	{
		final String regEx;

		regEx = "[1-3]?[0-9]\\.\\s" + DBConstants.SEASON_DAY;

		if (seasonDay == null || !seasonDay.matches(regEx))
			throw new IllegalArgumentException("The parameter must match the regular expression '" + regEx + "'.");

		return matchRepository.findBySeasonDay(seasonDay);
	}


	public List<String> getSeasonDayNames()
	{
		final List<DBMatch> resultList;
		final List<String>  seasonDayNames;

		resultList     = matchRepository.findSeasonDayBy();
		seasonDayNames = new ArrayList<>();

		resultList.forEach(result ->
		{
			if (!seasonDayNames.contains(result.getSeasonDay()))
				seasonDayNames.add(result.getSeasonDay());
		});

		seasonDayNames.sort((o1, o2) ->
		{
			final int i1 = Integer.parseInt(o1.substring(0, o1.indexOf('.')));
			final int i2 = Integer.parseInt(o2.substring(0, o2.indexOf('.')));

			return Integer.compare(i1, i2);
		});

		return seasonDayNames;
	}


	public List<DBTeam> getTeams()
	{
		return teamRepository.findAll();
	}


	public int fetchLeagueDataFromOpenLigaDB(final String leagueParam)
	{
		final Match[]       matches;
		final RestTemplate  restTemplate;

		restTemplate = new RestTemplate();
		matches      = restTemplate.getForObject(OpenLigaDBConstants.GET_MATCH_DATA.concat(leagueParam), Match[].class);

		return saveMatchesAndTeamsToDataBase(leagueParam, matches);
	}


	public Status updateUserBet(final String matchID, final String userID, final int goalsHome, final int goalsGuest)
	{
		final UserBet userBet;

		Status status;

		userBet = new UserBet(goalsGuest, goalsHome, userID);
		status  = matchRepository.removeBet(matchID, userID);

		if (status == Status.DELETED || status == Status.NOT_FOUND)
		{
			status = matchRepository.setBet(matchID, userBet);

			if (status == Status.CREATED)
				return Status.OK;
		}
		else if (status == Status.REJECTED)
		{
			return Status.REJECTED;
		}

		return Status.ERROR;
	}


	private int saveMatchesAndTeamsToDataBase(final String leagueParam, final Match[] matches)
	{
		final int               addedTeams;
		final List<DBMatch>     dbMatches;
		final Map<Long, DBTeam> dbTeams;

		dbMatches = new ArrayList<>();
		dbTeams   = new HashMap<>();

		for (final Match match : matches)
		{
			final DBMatch      dbMatch;
			final DBTeam       dbTeamGuest;
			final DBTeam       dbTeamHome;
			final List<DBGoal> dbGoals;

			dbGoals = new ArrayList<>();

			dbTeamHome  = _getDBTeam(match.getTeam1(), dbTeams);
			dbTeamGuest = _getDBTeam(match.getTeam2(), dbTeams);

			dbMatch = new DBMatch();
			dbMatch.setLeagueParam(leagueParam);
			dbMatch.setFinished(match.isMatchFinished());
			dbMatch.setMatchDateTimeUTC(match.getMatchDateTimeUTC());
			dbMatch.setMatchID(match.getMatchID());
			dbMatch.setSeasonDay(match.getGroup().getGroupName());
			dbMatch.setHomeTeamID(match.getTeam1().getTeamId());
			dbMatch.setGuestTeamID(match.getTeam2().getTeamId());
			dbMatch.setNumberOfViewers(match.getNumberOfViewers());
			dbMatch.setLocation(new DBLocation(match.getLocation().getLocationCity(),
			                                   match.getLocation().getLocationStadium()));

			for (final MatchResult matchResult : match.getMatchResults())
			{
				final DBMatchResult result = new DBMatchResult(matchResult.getPointsTeam1(), matchResult.getPointsTeam2());

				if (matchResult.getResultTypeID() == 1)
					dbMatch.setHalfTimeResult(result);
				else
					dbMatch.setEndResult(result);
			}

			for (final Goal goal : match.getGoals())
			{
				dbGoals.add(new DBGoal(goal.isPenalty(),
				                       goal.getMatchMinute(),
				                       goal.getScoreTeam2(),
				                       goal.getScoreTeam1(),
				                       goal.getGoalGetterName()));
			}

			dbMatch.setGoals(dbGoals.toArray(new DBGoal[0]));

			if (dbMatch.isFinished())
				_summarizeTeamData(dbTeamHome, dbTeamGuest, dbMatch.getEndResult());

			dbMatches.add(dbMatch);
		}

		addedTeams = teamRepository.saveAll(dbTeams.values()).size();

		LOGGER.info("{} were successfully added to the database.", addedTeams);

		return matchRepository.saveAll(dbMatches).size();
	}


	private DBTeam _getDBTeam(final Team team, final Map<Long, DBTeam> teamMap)
	{
		final DBTeam dbTeam;

		if (teamMap.containsKey(team.getTeamId()))
			return teamMap.get(team.getTeamId());

		dbTeam = new DBTeam();
		dbTeam.setTeamID(team.getTeamId());
		dbTeam.setShortName(team.getShortName());
		dbTeam.setTeamIconURL(team.getTeamIconUrl());
		dbTeam.setTeamName(team.getTeamName());

		teamMap.put(team.getTeamId(), dbTeam);

		return dbTeam;
	}


	private void _summarizeTeamData(final DBTeam homeTeam, final DBTeam guestTeam, final DBMatchResult result)
	{
		int pointsGuest = result.getPointsGuest();
		int pointsHome  = result.getPointsHome();

		homeTeam.setGoals(homeTeam.getGoals() + pointsHome);
		homeTeam.setGoalsAgainst(homeTeam.getGoalsAgainst() + pointsGuest);

		guestTeam.setGoals(guestTeam.getGoals() + pointsGuest);
		guestTeam.setGoalsAgainst(guestTeam.getGoalsAgainst() + pointsHome);

		if (pointsHome == pointsGuest)
		{
			homeTeam.setDraws(homeTeam.getDraws() + 1);
			homeTeam.setPoints(homeTeam.getPoints() + 1);

			guestTeam.setDraws(guestTeam.getDraws() + 1);
			guestTeam.setPoints(guestTeam.getPoints() + 1);
		}
		else if (pointsHome > pointsGuest)
		{
			homeTeam.setWins(homeTeam.getWins() + 1);
			homeTeam.setPoints(homeTeam.getPoints() + 3);

			guestTeam.setDefeats(guestTeam.getDefeats() + 1);
		}
		else
		{
			homeTeam.setDefeats(homeTeam.getDefeats() + 1);

			guestTeam.setWins(guestTeam.getWins() + 1);
			guestTeam.setPoints(guestTeam.getPoints() + 3);
		}
	}
}
