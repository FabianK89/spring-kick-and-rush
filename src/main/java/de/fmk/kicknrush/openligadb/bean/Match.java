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


	public boolean isMatchFinished()
	{
		return matchIsFinished;
	}


	public void setMatchIsFinished(boolean matchIsFinished)
	{
		this.matchIsFinished = matchIsFinished;
	}


	public Goal[] getGoals()
	{
		return goals;
	}


	public void setGoals(Goal[] goals)
	{
		this.goals = goals;
	}


	public Group getGroup()
	{
		return group;
	}


	public void setGroup(Group group)
	{
		this.group = group;
	}


	public int getNumberOfViewers()
	{
		return numberOfViewers;
	}


	public void setNumberOfViewers(int numberOfViewers)
	{
		this.numberOfViewers = numberOfViewers;
	}


	public Location getLocation()
	{
		return location;
	}


	public void setLocation(Location location)
	{
		this.location = location;
	}


	public long getLeagueId()
	{
		return leagueId;
	}


	public void setLeagueId(long leagueId)
	{
		this.leagueId = leagueId;
	}


	public long getMatchID()
	{
		return matchID;
	}


	public void setMatchID(long matchID)
	{
		this.matchID = matchID;
	}


	public MatchResult[] getMatchResults()
	{
		return matchResults;
	}


	public void setMatchResults(MatchResult[] matchResults)
	{
		this.matchResults = matchResults;
	}


	public String getLastUpdateDateTime()
	{
		return lastUpdateDateTime;
	}


	public void setLastUpdateDateTime(String lastUpdateDateTime)
	{
		this.lastUpdateDateTime = lastUpdateDateTime;
	}


	public String getLeagueName()
	{
		return leagueName;
	}


	public void setLeagueName(String leagueName)
	{
		this.leagueName = leagueName;
	}


	public String getMatchDateTimeUTC()
	{
		return matchDateTimeUTC;
	}


	public void setMatchDateTimeUTC(String matchDateTimeUTC)
	{
		this.matchDateTimeUTC = matchDateTimeUTC;
	}


	public String getTimeZoneID()
	{
		return timeZoneID;
	}


	public void setTimeZoneID(String timeZoneID)
	{
		this.timeZoneID = timeZoneID;
	}


	public Team getTeam1()
	{
		return team1;
	}


	public void setTeam1(Team team1)
	{
		this.team1 = team1;
	}


	public Team getTeam2()
	{
		return team2;
	}


	public void setTeam2(Team team2)
	{
		this.team2 = team2;
	}
}
