package de.fmk.kicknrush.model;

import de.fmk.kicknrush.mongodb.UserRepository;
import de.fmk.kicknrush.mongodb.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserDataHandler
{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDataHandler.class);

	@Autowired
	private UserRepository userRepository;


	public List<User> getAllUser()
	{
		return userRepository.findAll();
	}


	public void createUsers()
	{
		final int        createdUsers;
		final List<User> userList;

		userList = new ArrayList<>();
		userList.add(new User("mrbaam", "12345", "mrbaam@test.com"));
		userList.add(new User("topscorer", "abcde", "topscorer@test-mail.de"));
		userList.add(new User("Tod aller Chancen", "xxxxx", "tac@mail.com"));

		createdUsers = userRepository.saveAll(userList).size();

		if (createdUsers > 0)
			LOGGER.info("{} users were successfully added to the database.", createdUsers);
		else
			LOGGER.info("No users were added to the database.");
	}
}
