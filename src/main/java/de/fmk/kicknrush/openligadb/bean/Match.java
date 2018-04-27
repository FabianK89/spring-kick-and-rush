package de.fmk.kicknrush.openligadb.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Match
{
	private boolean       matchIsFinished;
	private Goal[]        goals;
	private Group         group;
	private int           numberOfViewers;
	private Location      location;
	private long          leagueId;
	private long          matchID;
	private MatchResult[] matchResults;
	private String        lastUpdateDateTime;
	private String        leagueName;
	private String        matchDateTimeUTC;
	private String        timeZoneID;
	private Team          team1;
	private Team          team2;


	public boolean isMatchIsFinished()
	{
		return matchIsFinished;
	}


	public void setMatchIsFinished(boolean p_matchIsFinished)
	{
		matchIsFinished = p_matchIsFinished;
	}


	public Goal[] getGoals()
	{
		return goals;
	}


	public void setGoals(Goal[] p_goals)
	{
		goals = p_goals;
	}


	public Group getGroup()
	{
		return group;
	}


	public void setGroup(Group p_group)
	{
		group = p_group;
	}


	public int getNumberOfViewers()
	{
		return numberOfViewers;
	}


	public void setNumberOfViewers(int p_numberOfViewers)
	{
		numberOfViewers = p_numberOfViewers;
	}


	public Location getLocation()
	{
		return location;
	}


	public void setLocation(Location p_location)
	{
		location = p_location;
	}


	public long getLeagueId()
	{
		return leagueId;
	}


	public void setLeagueId(long p_leagueId)
	{
		leagueId = p_leagueId;
	}


	public long getMatchID()
	{
		return matchID;
	}


	public void setMatchID(long p_matchID)
	{
		matchID = p_matchID;
	}


	public MatchResult[] getMatchResults()
	{
		return matchResults;
	}


	public void setMatchResults(MatchResult[] p_matchResults)
	{
		matchResults = p_matchResults;
	}


	public String getLastUpdateDateTime()
	{
		return lastUpdateDateTime;
	}


	public void setLastUpdateDateTime(String p_lastUpdateDateTime)
	{
		lastUpdateDateTime = p_lastUpdateDateTime;
	}


	public String getLeagueName()
	{
		return leagueName;
	}


	public void setLeagueName(String p_leagueName)
	{
		leagueName = p_leagueName;
	}


	public String getMatchDateTimeUTC()
	{
		return matchDateTimeUTC;
	}


	public void setMatchDateTimeUTC(String p_matchDateTimeUTC)
	{
		matchDateTimeUTC = p_matchDateTimeUTC;
	}


	public String getTimeZoneID()
	{
		return timeZoneID;
	}


	public void setTimeZoneID(String p_timeZoneID)
	{
		timeZoneID = p_timeZoneID;
	}


	public Team getTeam1()
	{
		return team1;
	}


	public void setTeam1(Team p_team1)
	{
		team1 = p_team1;
	}


	public Team getTeam2()
	{
		return team2;
	}


	public void setTeam2(Team p_team2)
	{
		team2 = p_team2;
	}
}
