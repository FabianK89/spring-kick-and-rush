package de.fmk.kicknrush.mongodb.bean;


public class DBTeam
{
	private long   teamID;
	private String shortName;
	private String teamIconURL;
	private String teamName;


	public DBTeam() {}


	public DBTeam(long p_teamID, String p_shortName, String p_teamIconURL, String p_teamName)
	{
		teamID      = p_teamID;
		shortName   = p_shortName;
		teamIconURL = p_teamIconURL;
		teamName    = p_teamName;
	}


	public long getTeamID()
	{
		return teamID;
	}


	public void setTeamID(long p_teamID)
	{
		teamID = p_teamID;
	}


	public String getShortName()
	{
		return shortName;
	}


	public void setShortName(String p_shortName)
	{
		shortName = p_shortName;
	}


	public String getTeamIconURL()
	{
		return teamIconURL;
	}


	public void setTeamIconURL(String p_teamIconURL)
	{
		teamIconURL = p_teamIconURL;
	}


	public String getTeamName()
	{
		return teamName;
	}


	public void setTeamName(String p_teamName)
	{
		teamName = p_teamName;
	}
}
