package de.fmk.kicknrush.service.controller;

import de.fmk.kicknrush.model.DataHandler;
import de.fmk.kicknrush.mongodb.bean.DBTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ComponentScan(basePackages = "de.fmk.kicknrush.model")
public class TeamController
{
	@Autowired
	private DataHandler dataHandler;


	@RequestMapping("/getTeams")
	public DBTeam[] getTeams()
	{
		return dataHandler.getTeams().toArray(new DBTeam[0]);
	}
}
