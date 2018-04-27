package de.fmk.kicknrush.mongodb.bean;


public class DBLocation
{
	private String city;
	private String stadium;


	public DBLocation(String p_city, String p_stadium)
	{
		city    = p_city;
		stadium = p_stadium;
	}


	public String getCity()
	{
		return city;
	}


	public void setCity(String p_city)
	{
		city = p_city;
	}


	public String getStadium()
	{
		return stadium;
	}


	public void setStadium(String p_stadium)
	{
		stadium = p_stadium;
	}
}
