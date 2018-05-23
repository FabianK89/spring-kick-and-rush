package de.fmk.kicknrush.service.controller;

import de.fmk.kicknrush.model.DataHandler;
import de.fmk.kicknrush.service.bean.Bet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ComponentScan(basePackages = "de.fmk.kicknrush.model")
public class BetController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(BetController.class);

	@Autowired
	private DataHandler dataHandler;


	@RequestMapping(value = "/saveBet", method = RequestMethod.POST)
	public ResponseEntity<String> saveBet(@RequestBody Bet bet)
	{
		final boolean result;

		LOGGER.info("Try to update the bet of the user with id '{}'.", bet.getUserID());

		result = dataHandler.updateUserBet(bet.getMatchID(), bet.getUserID(), bet.getGoalsHome(), bet.getGoalsGuest());

		if (result)
		{
			LOGGER.info("Updating the bet of the user with id '{}' was successful.", bet.getUserID());
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}

		LOGGER.info("No bet has been updated.");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
