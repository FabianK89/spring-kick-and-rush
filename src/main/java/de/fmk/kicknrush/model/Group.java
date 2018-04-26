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
public class Group
{
	private long   groupID;
	private String groupName;
	private int    groupOrderID;


	public long getGroupID()
	{
		return groupID;
	}


	public void setGroupID(long p_groupID)
	{
		groupID = p_groupID;
	}


	public String getGroupName()
	{
		return groupName;
	}


	public void setGroupName(String p_groupName)
	{
		groupName = p_groupName;
	}


	public int getGroupOrderID()
	{
		return groupOrderID;
	}


	public void setGroupOrderID(int p_groupOrderID)
	{
		groupOrderID = p_groupOrderID;
	}


	@Override
	public String toString()
	{
		return "Group{" +
				"groupID=" + groupID +
				", groupName='" + groupName + '\'' +
				", groupOrderID=" + groupOrderID +
				'}';
	}
}
