package de.fmk.kicknrush.openligadb.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Location
{
	private long   locationID;
	private String locationCity;
	private String locationStadium;


	public String getLocationCity()
	{
		return locationCity;
	}


	public void setLocationCity(String p_locationCity)
	{
		locationCity = p_locationCity;
	}


	public long getLocationID()
	{
		return locationID;
	}


	public void setLocationID(long p_locationID)
	{
		locationID = p_locationID;
	}


	public String getLocationStadium()
	{
		return locationStadium;
	}


	public void setLocationStadium(String p_locationStadium)
	{
		locationStadium = p_locationStadium;
	}
}
