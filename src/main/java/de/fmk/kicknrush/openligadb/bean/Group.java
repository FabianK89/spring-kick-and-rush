package de.fmk.kicknrush.openligadb.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Group
{
	private int    groupOrderID;
	private long   groupID;
	private String groupName;


	public long getGroupID()
	{
		return groupID;
	}


	public void setGroupID(long groupID)
	{
		this.groupID = groupID;
	}


	public String getGroupName()
	{
		return groupName;
	}


	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}


	public int getGroupOrderID()
	{
		return groupOrderID;
	}


	public void setGroupOrderID(int groupOrderID)
	{
		this.groupOrderID = groupOrderID;
	}
}
