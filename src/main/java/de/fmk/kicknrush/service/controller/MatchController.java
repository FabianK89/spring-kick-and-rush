package de.fmk.kicknrush.service.controller;

import de.fmk.kicknrush.model.DataHandler;
import de.fmk.kicknrush.mongodb.DBConstants;
import de.fmk.kicknrush.mongodb.bean.DBMatch;
import de.fmk.kicknrush.service.MatchInfoFactory;
import de.fmk.kicknrush.service.bean.MatchInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@ComponentScan(basePackages = "de.fmk.kicknrush.model")
public class MatchController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MatchController.class);

	@Autowired
	private DataHandler dataHandler;


	@RequestMapping("/getMatchesForSeasonDay")
	public MatchInfo[] getMatchesForSeasonDay(@RequestParam(value = "num") int num)
	{
		final List<DBMatch>    matches;
		final List<MatchInfo>  result;
		final MatchInfoFactory fac;
		final String           seasonDay;

		if (num < 1 || num > 34)
			return new MatchInfo[0];

		seasonDay = Integer.toString(num).concat(". ").concat(DBConstants.SEASON_DAY);
		matches   = dataHandler.getMatchesForSeasonDay(seasonDay);
		result    = new ArrayList<>();
		fac       = MatchInfoFactory.getInstance();

		matches.forEach(match -> result.add(fac.createMatchInfo(match)));

		return result.toArray(new MatchInfo[0]);
	}
}
