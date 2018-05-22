package de.fmk.kicknrush.mongodb.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User
{
	@Id
	private String id;

	private int    points;
	private String userName;
	private String password;
	private String email;


	public User(String userName, String password, String email)
	{
		this.userName = userName;
		this.password = password;
		this.email    = email;
	}
}
