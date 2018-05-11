package de.fmk.kicknrush.mongodb.bean;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "matches")
public class DBMatch
{
	@Id
	private String id;

	private boolean       isFinished;
	private DBGoal[]      goals;
	private DBMatchResult endResult;
	private DBMatchResult halfTimeResult;
	private int           numberOfViewers;
	private long          guestTeamID;
	private long          homeTeamID;
	private long          matchID;
	private String        leagueParam;
	private DBLocation    location;
	private String        matchDateTimeUTC;
	private String        seasonDay;


	public String getId()
	{
		return id;
	}


	public void setId(String id)
	{
		this.id = id;
	}


	public boolean isFinished()
	{
		return isFinished;
	}


	public void setFinished(boolean finished)
	{
		this.isFinished = finished;
	}


	public DBGoal[] getGoals()
	{
		return goals;
	}


	public void setGoals(DBGoal[] goals)
	{
		this.goals = goals;
	}


	public DBMatchResult getEndResult()
	{
		return endResult;
	}


	public void setEndResult(DBMatchResult endResult)
	{
		this.endResult = endResult;
	}


	public DBMatchResult getHalfTimeResult()
	{
		return halfTimeResult;
	}


	public void setHalfTimeResult(DBMatchResult halfTimeResult)
	{
		this.halfTimeResult = halfTimeResult;
	}


	public int getNumberOfViewers()
	{
		return numberOfViewers;
	}


	public void setNumberOfViewers(int numberOfViewers)
	{
		this.numberOfViewers = numberOfViewers;
	}


	public long getGuestTeamID()
	{
		return guestTeamID;
	}


	public void setGuestTeamID(long guestTeamID)
	{
		this.guestTeamID = guestTeamID;
	}


	public long getHomeTeamID()
	{
		return homeTeamID;
	}


	public void setHomeTeamID(long homeTeamID)
	{
		this.homeTeamID = homeTeamID;
	}


	public long getMatchID()
	{
		return matchID;
	}


	public void setMatchID(long matchID)
	{
		this.matchID = matchID;
	}


	public String getLeagueParam()
	{
		return leagueParam;
	}


	public void setLeagueParam(String leagueParam)
	{
		this.leagueParam = leagueParam;
	}


	public DBLocation getLocation()
	{
		return location;
	}


	public void setLocation(DBLocation location)
	{
		this.location = location;
	}


	public String getMatchDateTimeUTC()
	{
		return matchDateTimeUTC;
	}


	public void setMatchDateTimeUTC(String matchDateTimeUTC)
	{
		this.matchDateTimeUTC = matchDateTimeUTC;
	}


	public String getSeasonDay()
	{
		return seasonDay;
	}


	public void setSeasonDay(String seasonDay)
	{
		this.seasonDay = seasonDay;
	}
}
