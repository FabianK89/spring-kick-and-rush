package de.fmk.kicknrush.mongodb.bean;


public class DBTeam
{
	private long   teamID;
	private String shortName;
	private String teamIconURL;
	private String teamName;


	public DBTeam() {}


	public DBTeam(long teamID, String shortName, String teamIconURL, String teamName)
	{
		this.teamID      = teamID;
		this.shortName   = shortName;
		this.teamIconURL = teamIconURL;
		this.teamName    = teamName;
	}


	public long getTeamID()
	{
		return teamID;
	}


	public void setTeamID(long teamID)
	{
		this.teamID = teamID;
	}


	public String getShortName()
	{
		return shortName;
	}


	public void setShortName(String shortName)
	{
		this.shortName = shortName;
	}


	public String getTeamIconURL()
	{
		return teamIconURL;
	}


	public void setTeamIconURL(String teamIconURL)
	{
		this.teamIconURL = teamIconURL;
	}


	public String getTeamName()
	{
		return teamName;
	}


	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}
}
