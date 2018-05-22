package de.fmk.kicknrush.app;

import de.fmk.kicknrush.model.UserDataHandler;
import de.fmk.kicknrush.mongodb.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;


/**
 * https://stackoverflow.com/questions/20387881/how-to-run-certain-task-every-day-at-a-particular-time-using-scheduledexecutorse
 */
@SpringBootApplication
@EnableScheduling
@EnableMongoRepositories("de.fmk.kicknrush.mongodb")
@ComponentScan(basePackages = { "de.fmk.kicknrush.task", "de.fmk.kicknrush.service" })
public class Application
{
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	@Autowired
	private UserDataHandler userDataHandler;


	public static void main(String[] args)
	{
		SpringApplication.run(Application.class);
	}


	@Bean
	public CommandLineRunner run()
	{
		return args ->
		{
			final List<User> userList;

			LOGGER.info("Check for users.");

			userList = userDataHandler.getAllUser();

			if (userList.isEmpty())
				userDataHandler.createUsers();
			else
				LOGGER.info("Users already exist in database.");
		};
	}
}
