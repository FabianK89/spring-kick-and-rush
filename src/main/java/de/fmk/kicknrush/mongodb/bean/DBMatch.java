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
	private DBTeam        guestTeam;
	private DBTeam        homeTeam;
	private int           numberOfViewers;
	private long          matchID;
	private String        leagueParam;
	private DBLocation    location;
	private String        matchDateTimeUTC;
	private String        seasonDay;


	public String getId()
	{
		return id;
	}


	public void setId(String p_id)
	{
		id = p_id;
	}


	public boolean isFinished()
	{
		return isFinished;
	}


	public void setFinished(boolean p_finished)
	{
		isFinished = p_finished;
	}


	public DBGoal[] getGoals()
	{
		return goals;
	}


	public void setGoals(DBGoal[] p_goals)
	{
		goals = p_goals;
	}


	public DBMatchResult getEndResult()
	{
		return endResult;
	}


	public void setEndResult(DBMatchResult p_endResult)
	{
		endResult = p_endResult;
	}


	public DBMatchResult getHalfTimeResult()
	{
		return halfTimeResult;
	}


	public void setHalfTimeResult(DBMatchResult p_halfTimeResult)
	{
		halfTimeResult = p_halfTimeResult;
	}


	public DBTeam getGuestTeam()
	{
		return guestTeam;
	}


	public void setGuestTeam(DBTeam p_guestTeam)
	{
		guestTeam = p_guestTeam;
	}


	public DBTeam getHomeTeam()
	{
		return homeTeam;
	}


	public void setHomeTeam(DBTeam p_homeTeam)
	{
		homeTeam = p_homeTeam;
	}


	public int getNumberOfViewers()
	{
		return numberOfViewers;
	}


	public void setNumberOfViewers(int p_numberOfViewers)
	{
		numberOfViewers = p_numberOfViewers;
	}


	public long getMatchID()
	{
		return matchID;
	}


	public void setMatchID(long p_matchID)
	{
		matchID = p_matchID;
	}


	public String getLeagueParam()
	{
		return leagueParam;
	}


	public void setLeagueParam(String p_leagueParam)
	{
		leagueParam = p_leagueParam;
	}


	public DBLocation getLocation()
	{
		return location;
	}


	public void setLocation(DBLocation p_location)
	{
		location = p_location;
	}


	public String getMatchDateTimeUTC()
	{
		return matchDateTimeUTC;
	}


	public void setMatchDateTimeUTC(String p_matchDateTimeUTC)
	{
		matchDateTimeUTC = p_matchDateTimeUTC;
	}


	public String getSeasonDay()
	{
		return seasonDay;
	}


	public void setSeasonDay(String p_seasonDay)
	{
		seasonDay = p_seasonDay;
	}
}
