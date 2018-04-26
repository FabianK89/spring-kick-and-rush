package de.fmk.kicknrush.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author <a href="mailto:Fabian.Kiesl@unitedplanet.de">Fabian Kiesl</a>
 * @version $Revision$
 *
 * https://stackoverflow.com/questions/20387881/how-to-run-certain-task-every-day-at-a-particular-time-using-scheduledexecutorse
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "de.fmk.kicknrush.task")
public class Application
{
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);


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
