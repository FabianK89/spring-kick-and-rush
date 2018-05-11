package de.fmk.kicknrush.app;

import de.fmk.kicknrush.model.DataHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


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
	private DataHandler dataHandler;


	public static void main(String[] args)
	{
		SpringApplication.run(Application.class);

		LOGGER.info("Test");
	}


//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder)
//	{
//		return builder.build();
//	}


//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception
//	{
//		return args -> {
//			final Thread thread = new Thread(() ->
//			{
//				try
//				{
//					Thread.sleep(60000L);
//				}
//				catch (InterruptedException p_e)
//				{
//					LOGGER.error(p_e.getMessage(), p_e);
//				}
//
//				Team[] teams = restTemplate.getForObject("https://www.openligadb.de/api/getavailableteams/bl1/2016", Team[].class);
//
//				for (final Team team : teams)
//					LOGGER.info(team.toString());
//			});
//
//			thread.start();
//		};
//	}
}
