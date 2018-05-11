package de.fmk.kicknrush.mongodb.bean;


public class DBLocation
{
	private String city;
	private String stadium;


	public DBLocation(String city, String stadium)
	{
		this.city    = city;
		this.stadium = stadium;
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
