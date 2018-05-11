package de.fmk.kicknrush.mongodb.bean;


public class DBGoal
{
	private boolean isPenalty;
	private int     matchMinute;
	private int     scoreGuest;
	private int     scoreHome;
	private String  goalGetter;


	public DBGoal(boolean isPenalty, int matchMinute, int scoreGuest, int scoreHome, String goalGetter)
	{
		this.isPenalty   = isPenalty;
		this.matchMinute = matchMinute;
		this.scoreGuest  = scoreGuest;
		this.scoreHome   = scoreHome;
		this.goalGetter  = goalGetter;
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


	public int getScoreGuest()
	{
		return scoreGuest;
	}


	public void setScoreGuest(int scoreGuest)
	{
		this.scoreGuest = scoreGuest;
	}


	public int getScoreHome()
	{
		return scoreHome;
	}


	public void setScoreHome(int scoreHome)
	{
		this.scoreHome = scoreHome;
	}


	public String getGoalGetter()
	{
		return goalGetter;
	}


	public void setGoalGetter(String goalGetter)
	{
		this.goalGetter = goalGetter;
	}
}
