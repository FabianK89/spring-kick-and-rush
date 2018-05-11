package de.fmk.kicknrush.mongodb.bean;


public class DBMatchResult
{
	private int pointsGuest;
	private int pointsHome;


	public DBMatchResult(int pointsHome, int pointsGuest)
	{
		this.pointsHome  = pointsHome;
		this.pointsGuest = pointsGuest;
	}


	public int getPointsHome()
	{
		return pointsHome;
	}


	public void setPointsHome(int pointsHome)
	{
		this.pointsHome = pointsHome;
	}


	public int getPointsGuest()
	{
		return pointsGuest;
	}


	public void setPointsGuest(int pointsGuest)
	{
		this.pointsGuest = pointsGuest;
	}
}
