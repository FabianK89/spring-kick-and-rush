package de.fmk.kicknrush.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


/**
 * @author <a href="mailto:Fabian.Kiesl@unitedplanet.de">Fabian Kiesl</a>
 * @version $Revision$
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Match
{
	private Group group;
	private String lastUpdateDateTime;
	private long leagueId;
	private String leagueName;
	private Location location;
	private String matchDateTime;
	private long matchID;
	private boolean matchIsFinished;
	private MatchResult[] matchResults;


	public Group getGroup()
	{
		return group;
	}


	public void setGroup(Group p_group)
	{
		group = p_group;
	}


	public String getLastUpdateDateTime()
	{
		return lastUpdateDateTime;
	}


	public void setLastUpdateDateTime(String p_lastUpdateDateTime)
	{
		lastUpdateDateTime = p_lastUpdateDateTime;
	}


	public long getLeagueId()
	{
		return leagueId;
	}


	public void setLeagueId(long p_leagueId)
	{
		leagueId = p_leagueId;
	}


	public String getLeagueName()
	{
		return leagueName;
	}


	public void setLeagueName(String p_leagueName)
	{
		leagueName = p_leagueName;
	}


	public Location getLocation()
	{
		return location;
	}


	public void setLocation(Location p_location)
	{
		location = p_location;
	}


	public String getMatchDateTime()
	{
		return matchDateTime;
	}


	public void setMatchDateTime(String p_matchDateTime)
	{
		matchDateTime = p_matchDateTime;
	}


	public long getMatchID()
	{
		return matchID;
	}


	public void setMatchID(long p_matchID)
	{
		matchID = p_matchID;
	}


	public boolean isMatchIsFinished()
	{
		return matchIsFinished;
	}


	public void setMatchIsFinished(boolean p_matchIsFinished)
	{
		matchIsFinished = p_matchIsFinished;
	}


	public MatchResult[] getMatchResults()
	{
		return matchResults;
	}


	public void setMatchResults(MatchResult[] p_matchResults)
	{
		matchResults = p_matchResults;
	}
}
