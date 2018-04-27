package de.fmk.kicknrush.task;

import de.fmk.kicknrush.model.DataHandler;
import de.fmk.kicknrush.openligadb.OpenLigaDBConstants;
import de.fmk.kicknrush.openligadb.bean.Match;
import de.fmk.kicknrush.openligadb.bean.MatchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;


@Component
@ComponentScan(basePackages = "de.fmk.kicknrush.model")
public class MatchdayTask
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MatchdayTask.class);

	@Autowired
	private DataHandler dataHandler;


//	@Scheduled(cron = "0 0 0 * 7,8 TUE")
	@Scheduled(cron = "0 07-08 17 * * *")
	public void createInitialLeagueMatches()
	{
		final int       matchesAdded;
		final LocalDate date;
		final String    leagueParam;
		final String    webserviceURL;

		date        = LocalDate.now();
		leagueParam = "bl1/" + 2017; // TODO change date

		LOGGER.info("Check if data for league {} is already available in the database.", leagueParam);

		if (dataHandler.hasDataForLeague(leagueParam))
		{
			LOGGER.info("The database already contains data for league {}.", leagueParam);
			return;
		}

		webserviceURL = OpenLigaDBConstants.GET_MATCH_DATA.concat(leagueParam);

		LOGGER.info("Fetch data from {}.", webserviceURL);

		matchesAdded = dataHandler.fetchDataFromOpenLigaDB(leagueParam);

		LOGGER.info("{} matches were successfully added to the database.", matchesAdded);
	}


	@Scheduled(cron = "0 18 17 * * *")
	public void startFetchingMatchData()
	{
		RestTemplate restTemplate = new RestTemplate();

		Match[] matches = restTemplate.getForObject("https://www.openligadb.de/api/getmatchdata/bl1/2017", Match[].class);

		for (Match match : matches)
		{
			LOGGER.info(Long.toString(match.getMatchID()));
			for (MatchResult result : match.getMatchResults())
				LOGGER.info(result.toString());
		}
	}
}
