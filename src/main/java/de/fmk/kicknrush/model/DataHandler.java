package de.fmk.kicknrush.model;


import de.fmk.kicknrush.mongodb.MatchRepository;
import de.fmk.kicknrush.mongodb.bean.DBMatch;
import de.fmk.kicknrush.mongodb.bean.DBTeam;
import de.fmk.kicknrush.openligadb.OpenLigaDBConstants;
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


	public boolean hasDataForLeague(final String p_leagueParam)
	{
		final List<DBMatch> matches = matchRepository.findByLeagueParam(p_leagueParam);

		return matches != null && !matches.isEmpty();
	}


	public int fetchDataFromOpenLigaDB(final String p_leagueParam)
	{
		final List<DBMatch> dbMatches;
		final Match[]       matches;
		final RestTemplate  restTemplate;

		dbMatches    = new ArrayList<>();
		restTemplate = new RestTemplate();
		matches      = restTemplate.getForObject(OpenLigaDBConstants.GET_MATCH_DATA.concat(p_leagueParam), Match[].class);

		for (final Match match : matches)
		{
			final DBMatch dbMatch;

			dbMatch = new DBMatch();
			dbMatch.setLeagueParam(p_leagueParam);
			dbMatch.setFinished(match.isMatchIsFinished());
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

			for (final MatchResult matchResult : match.getMatchResults())
			{

			}

			dbMatches.add(dbMatch);
		}

		return matchRepository.saveAll(dbMatches).size();
	}
}
