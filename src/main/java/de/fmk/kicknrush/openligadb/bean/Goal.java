package de.fmk.kicknrush.openligadb.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Goal
{
	private boolean isOvertime;
	private boolean isOwnGoal;
	private boolean isPenalty;
	private int     matchMinute;
	private int     scoreTeam1;
	private int     scoreTeam2;
	private long    goalGetterID;
	private long    goalID;
	private String  goalGetterName;


	public boolean isOvertime()
	{
		return isOvertime;
	}


	public void setOvertime(boolean overtime)
	{
		this.isOvertime = overtime;
	}


	public boolean isOwnGoal()
	{
		return isOwnGoal;
	}


	public void setOwnGoal(boolean ownGoal)
	{
		this.isOwnGoal = ownGoal;
	}


	public boolean isPenalty()
	{
		return isPenalty;
	}


	public void setPenalty(boolean penalty)
	{
		this.isPenalty = penalty;
	}


	public int getMatchMinute()
	{
		return matchMinute;
	}


	public void setMatchMinute(int matchMinute)
	{
		this.matchMinute = matchMinute;
	}


	public int getScoreTeam1()
	{
		return scoreTeam1;
	}


	public void setScoreTeam1(int scoreTeam1)
	{
		this.scoreTeam1 = scoreTeam1;
	}


	public int getScoreTeam2()
	{
		return scoreTeam2;
	}


	public void setScoreTeam2(int scoreTeam2)
	{
		this.scoreTeam2 = scoreTeam2;
	}


	public long getGoalGetterID()
	{
		return goalGetterID;
	}


	public void setGoalGetterID(long goalGetterID)
	{
		this.goalGetterID = goalGetterID;
	}


	public long getGoalID()
	{
		return goalID;
	}


	public void setGoalID(long goalID)
	{
		this.goalID = goalID;
	}


	public String getGoalGetterName()
	{
		return goalGetterName;
	}


	public void setGoalGetterName(String goalGetterName)
	{
		this.goalGetterName = goalGetterName;
	}
}
