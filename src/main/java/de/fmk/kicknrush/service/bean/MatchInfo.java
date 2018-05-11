package de.fmk.kicknrush.service.bean;


public class MatchInfo
{
	private boolean finished;
	private int     goalsGuest;
	private int     goalsHome;
	private long    matchID;
	private String  beginUTC;
	private String  city;
	private String  stadium;


	public boolean isFinished()
	{
		return finished;
	}


	public void setFinished(boolean finished)
	{
		this.finished = finished;
	}


	public int getGoalsGuest()
	{
		return goalsGuest;
	}


	public void setGoalsGuest(int goalsGuest)
	{
		this.goalsGuest = goalsGuest;
	}


	public int getGoalsHome()
	{
		return goalsHome;
	}


	public void setGoalsHome(int goalsHome)
	{
		this.goalsHome = goalsHome;
	}


	public long getMatchID()
	{
		return matchID;
	}


	public void setMatchID(long matchID)
	{
		this.matchID = matchID;
	}


	public String getBeginUTC()
	{
		return beginUTC;
	}


	public void setBeginUTC(String beginUTC)
	{
		this.beginUTC = beginUTC;
	}


	public String getCity()
	{
		return city;
	}


	public void setCity(String city)
	{
		this.city = city;
	}


	public String getStadium()
	{
		return stadium;
	}


	public void setStadium(String stadium)
	{
		this.stadium = stadium;
	}
}
