package de.fmk.kicknrush.service.controller;

import de.fmk.kicknrush.model.DataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ComponentScan(basePackages = "de.fmk.kicknrush.model")
public class SeasonDayController
{
	@Autowired
	private DataHandler dataHandler;


	@RequestMapping("/test")
	public String test()
	{
		return "test";
	}


	@RequestMapping("/getSeasonDays")
	public String[] getSeasonDays()
	{
		return dataHandler.getSeasonDayNames().toArray(new String[0]);
	}
}
