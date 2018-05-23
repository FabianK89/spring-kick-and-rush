package de.fmk.kicknrush.service.bean;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Bet
{
	private int    goalsGuest;
	private int    goalsHome;
	private String matchID;
	private String userID;
}
