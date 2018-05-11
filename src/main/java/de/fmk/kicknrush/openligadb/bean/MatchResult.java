package de.fmk.kicknrush.openligadb.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class MatchResult
{
	private int    pointsTeam1;
	private int    pointsTeam2;
	private int    resultOrderID;
	private int    resultTypeID;
	private long   resultID;
	private String resultDescription;
	private String resultName;


	public int getPointsTeam1()
	{
		return pointsTeam1;
	}


	public void setPointsTeam1(int pointsTeam1)
	{
		this.pointsTeam1 = pointsTeam1;
	}


	public int getPointsTeam2()
	{
		return pointsTeam2;
	}


	public void setPointsTeam2(int pointsTeam2)
	{
		this.pointsTeam2 = pointsTeam2;
	}


	public String getResultDescription()
	{
		return resultDescription;
	}


	public void setResultDescription(String resultDescription)
	{
		this.resultDescription = resultDescription;
	}


	public long getResultID()
	{
		return resultID;
	}


	public void setResultID(long resultID)
	{
		this.resultID = resultID;
	}


	public String getResultName()
	{
		return resultName;
	}


	public void setResultName(String resultName)
	{
		this.resultName = resultName;
	}


	public int getResultOrderID()
	{
		return resultOrderID;
	}


	public void setResultOrderID(int resultOrderID)
	{
		this.resultOrderID = resultOrderID;
	}


	public int getResultTypeID()
	{
		return resultTypeID;
	}


	public void setResultTypeID(int resultTypeID)
	{
		this.resultTypeID = resultTypeID;
	}
}
