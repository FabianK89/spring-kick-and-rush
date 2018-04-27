package de.fmk.kicknrush.mongodb.bean;


public class DBMatchResult
{
	private int pointsGuest;
	private int pointsHome;


	public DBMatchResult(int p_pointsHome, int p_pointsGuest)
	{
		pointsHome  = p_pointsHome;
		pointsGuest = p_pointsGuest;
	}


	public int getPointsHome()
	{
		return pointsHome;
	}


	public void setPointsHome(int p_pointsHome)
	{
		pointsHome = p_pointsHome;
	}


	public int getPointsGuest()
	{
		return pointsGuest;
	}


	public void setPointsGuest(int p_pointsGuest)
	{
		pointsGuest = p_pointsGuest;
	}
}
