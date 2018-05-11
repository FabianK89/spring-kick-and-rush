package de.fmk.kicknrush.openligadb.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Team
{
	private long   teamId;
	private String shortName;
	private String teamIconUrl;
	private String teamName;



	public long getTeamId()
	{
		return teamId;
	}


	public void setTeamId(long teamId)
	{
		this.teamId = teamId;
	}


	public String getShortName()
	{
		return shortName;
	}


	public void setShortName(String shortName)
	{
		this.shortName = shortName;
	}


	public String getTeamIconUrl()
	{
		return teamIconUrl;
	}


	public void setTeamIconUrl(String teamIconUrl)
	{
		this.teamIconUrl = teamIconUrl;
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
