package de.fmk.kicknrush.service.bean;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MatchInfo
{
	private Bet[]   bets;
	private boolean finished;
	private int     goalsGuest;
	private int     goalsHome;
	private long    matchID;
	private String  beginUTC;
	private String  city;
	private String  stadium;
}
