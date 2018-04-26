package de.fmk.kicknrush.task;

import de.fmk.kicknrush.model.Match;
import de.fmk.kicknrush.model.MatchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * @author <a href="mailto:Fabian.Kiesl@unitedplanet.de">Fabian Kiesl</a>
 * @version $Revision$
 */
@Component
public class MatchdayTask
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MatchdayTask.class);


	@Scheduled(cron = "00 18 17 * * *")
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

//		Team[] teams = restTemplate.getForObject("https://www.openligadb.de/api/getavailableteams/bl1/2017", Team[].class);
//
//		for (final Team team : teams)
//			LOGGER.info(team.toString());
	}
}
