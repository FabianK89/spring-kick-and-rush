package de.fmk.kicknrush.model;


import de.fmk.kicknrush.mongodb.DBConstants;
import de.fmk.kicknrush.mongodb.MatchRepository;
import de.fmk.kicknrush.mongodb.bean.DBGoal;
import de.fmk.kicknrush.mongodb.bean.DBLocation;
import de.fmk.kicknrush.mongodb.bean.DBMatch;
import de.fmk.kicknrush.mongodb.bean.DBMatchResult;
import de.fmk.kicknrush.mongodb.bean.DBTeam;
import de.fmk.kicknrush.openligadb.OpenLigaDBConstants;
import de.fmk.kicknrush.openligadb.bean.Goal;
import de.fmk.kicknrush.openligadb.bean.Match;
import de.fmk.kicknrush.openligadb.bean.MatchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataHandler
{
	@Autowired
	private MatchRepository matchRepository;


	public boolean hasDataForLeague(final String leagueParam)
	{
		final List<DBMatch> matches;
		final String        regEx;

		regEx = "bl1\\/20[0-9]{2}";

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


	public int fetchLeagueDataFromOpenLigaDB(final String leagueParam)
	{
		final Match[]       matches;
		final RestTemplate  restTemplate;

		restTemplate = new RestTemplate();
		matches      = restTemplate.getForObject(OpenLigaDBConstants.GET_MATCH_DATA.concat(leagueParam), Match[].class);

		return saveMatchesToDataBase(leagueParam, matches);
	}


	private int saveMatchesToDataBase(final String leagueParam, final Match[] matches)
	{
		final List<DBMatch> dbMatches;

		dbMatches = new ArrayList<>();

		for (final Match match : matches)
		{
			final DBMatch      dbMatch;
			final List<DBGoal> dbGoals;

			dbGoals = new ArrayList<>();

			dbMatch = new DBMatch();
			dbMatch.setLeagueParam(leagueParam);
			dbMatch.setFinished(match.isMatchFinished());
			dbMatch.setMatchDateTimeUTC(match.getMatchDateTimeUTC());
			dbMatch.setMatchID(match.getMatchID());
			dbMatch.setSeasonDay(match.getGroup().getGroupName());
			dbMatch.setHomeTeam(new DBTeam(match.getTeam1().getTeamId(),
			                               match.getTeam1().getShortName(),
			                               match.getTeam1().getTeamIconUrl(),
			                               match.getTeam1().getTeamName()));
			dbMatch.setGuestTeam(new DBTeam(match.getTeam2().getTeamId(),
			                                match.getTeam2().getShortName(),
			                                match.getTeam2().getTeamIconUrl(),
			                                match.getTeam2().getTeamName()));
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

			dbMatches.add(dbMatch);
		}

		return matchRepository.saveAll(dbMatches).size();
	}
}
