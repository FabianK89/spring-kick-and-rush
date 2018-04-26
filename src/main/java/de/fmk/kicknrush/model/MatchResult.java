package de.fmk.kicknrush.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


/**
 * @author <a href="mailto:Fabian.Kiesl@unitedplanet.de">Fabian Kiesl</a>
 * @version $Revision$
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class MatchResult
{
	private int pointsTeam1;
	private int pointsTeam2;
	private String resultDescription;
	private long resultID;
	private String resultName;
	private int resultOrderID;
	private int resultTypeID;


	public int getPointsTeam1()
	{
		return pointsTeam1;
	}


	public void setPointsTeam1(int p_pointsTeam1)
	{
		pointsTeam1 = p_pointsTeam1;
	}


	public int getPointsTeam2()
	{
		return pointsTeam2;
	}


	public void setPointsTeam2(int p_pointsTeam2)
	{
		pointsTeam2 = p_pointsTeam2;
	}


	public String getResultDescription()
	{
		return resultDescription;
	}


	public void setResultDescription(String p_resultDescription)
	{
		resultDescription = p_resultDescription;
	}


	public long getResultID()
	{
		return resultID;
	}


	public void setResultID(long p_resultID)
	{
		resultID = p_resultID;
	}


	public String getResultName()
	{
		return resultName;
	}


	public void setResultName(String p_resultName)
	{
		resultName = p_resultName;
	}


	public int getResultOrderID()
	{
		return resultOrderID;
	}


	public void setResultOrderID(int p_resultOrderID)
	{
		resultOrderID = p_resultOrderID;
	}


	public int getResultTypeID()
	{
		return resultTypeID;
	}


	public void setResultTypeID(int p_resultTypeID)
	{
		resultTypeID = p_resultTypeID;
	}


	@Override
	public String toString()
	{
		return "MatchResult{" +
				"pointsTeam1=" + pointsTeam1 +
				", pointsTeam2=" + pointsTeam2 +
				", resultDescription='" + resultDescription + '\'' +
				", resultID=" + resultID +
				", resultName='" + resultName + '\'' +
				", resultOrderID=" + resultOrderID +
				", resultTypeID=" + resultTypeID +
				'}';
	}
}
