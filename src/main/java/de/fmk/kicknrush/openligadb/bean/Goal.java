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


	public void setOvertime(boolean p_overtime)
	{
		isOvertime = p_overtime;
	}


	public boolean isOwnGoal()
	{
		return isOwnGoal;
	}


	public void setOwnGoal(boolean p_ownGoal)
	{
		isOwnGoal = p_ownGoal;
	}


	public boolean isPenalty()
	{
		return isPenalty;
	}


	public void setPenalty(boolean p_penalty)
	{
		isPenalty = p_penalty;
	}


	public int getMatchMinute()
	{
		return matchMinute;
	}


	public void setMatchMinute(int p_matchMinute)
	{
		matchMinute = p_matchMinute;
	}


	public int getScoreTeam1()
	{
		return scoreTeam1;
	}


	public void setScoreTeam1(int p_scoreTeam1)
	{
		scoreTeam1 = p_scoreTeam1;
	}


	public int getScoreTeam2()
	{
		return scoreTeam2;
	}


	public void setScoreTeam2(int p_scoreTeam2)
	{
		scoreTeam2 = p_scoreTeam2;
	}


	public long getGoalGetterID()
	{
		return goalGetterID;
	}


	public void setGoalGetterID(long p_goalGetterID)
	{
		goalGetterID = p_goalGetterID;
	}


	public long getGoalID()
	{
		return goalID;
	}


	public void setGoalID(long p_goalID)
	{
		goalID = p_goalID;
	}


	public String getGoalGetterName()
	{
		return goalGetterName;
	}


	public void setGoalGetterName(String p_goalGetterName)
	{
		goalGetterName = p_goalGetterName;
	}
}
