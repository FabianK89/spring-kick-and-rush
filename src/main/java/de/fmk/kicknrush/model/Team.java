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
public class Team
{
	private int    teamId;
	private String shortName;
	private String teamIconUrl;
	private String teamName;


	public Team()
	{
	}


	public int getTeamId()
	{
		return teamId;
	}


	public void setTeamId(int p_teamId)
	{
		teamId = p_teamId;
	}


	public String getShortName()
	{
		return shortName;
	}


	public void setShortName(String p_shortName)
	{
		shortName = p_shortName;
	}


	public String getTeamIconUrl()
	{
		return teamIconUrl;
	}


	public void setTeamIconUrl(String p_teamIconUrl)
	{
		teamIconUrl = p_teamIconUrl;
	}


	public String getTeamName()
	{
		return teamName;
	}


	public void setTeamName(String p_teamName)
	{
		teamName = p_teamName;
	}


	@Override
	public String toString()
	{
		return "ID: " + getTeamId() + ", Name: " + getTeamName();
	}
}
