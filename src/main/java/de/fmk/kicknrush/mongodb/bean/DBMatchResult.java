package de.fmk.kicknrush.mongodb.bean;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class DBMatchResult
{
	private int pointsGuest;
	private int pointsHome;
}
