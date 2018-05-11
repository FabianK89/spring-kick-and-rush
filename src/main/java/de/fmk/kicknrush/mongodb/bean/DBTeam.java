package de.fmk.kicknrush.mongodb.bean;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "teams")
public class DBTeam
{
	@Id
	private String id;

	private int    defeats;
	private int    draws;
	private int    goals;
	private int    goalsAgainst;
	private int    points;
	private int    wins;
	private long   teamID;
	private String shortName;
	private String teamIconURL;
	private String teamName;


	public String getId()
	{
		return id;
	}


	public void setId(String id)
	{
		this.id = id;
	}


	public int getDefeats()
	{
		return defeats;
	}


	public void setDefeats(int defeats)
	{
		this.defeats = defeats;
	}


	public int getDraws()
	{
		return draws;
	}


	public void setDraws(int draws)
	{
		this.draws = draws;
	}


	public int getGoals()
	{
		return goals;
	}


	public void setGoals(int goals)
	{
		this.goals = goals;
	}


	public int getGoalsAgainst()
	{
		return goalsAgainst;
	}


	public void setGoalsAgainst(int goalsAgainst)
	{
		this.goalsAgainst = goalsAgainst;
	}


	public int getPoints()
	{
		return points;
	}


	public void setPoints(int points)
	{
		this.points = points;
	}


	public int getWins()
	{
		return wins;
	}


	public void setWins(int wins)
	{
		this.wins = wins;
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
