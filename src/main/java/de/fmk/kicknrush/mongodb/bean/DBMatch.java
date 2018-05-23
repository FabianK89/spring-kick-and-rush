package de.fmk.kicknrush.mongodb.bean;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "matches")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DBMatch
{
	@Id
	private String id;

	private boolean       isFinished;
	private DBGoal[]      goals;
	private DBLocation    location;
	private DBMatchResult endResult;
	private DBMatchResult halfTimeResult;
	private int           numberOfViewers;
	private long          guestTeamID;
	private long          homeTeamID;
	private long          matchID;
	private String        leagueParam;
	private String        matchDateTimeUTC;
	private String        seasonDay;
	private UserBet[]     userBets;
}
