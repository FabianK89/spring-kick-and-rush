package de.fmk.kicknrush.service;

import de.fmk.kicknrush.mongodb.bean.DBGoal;
import de.fmk.kicknrush.mongodb.bean.DBMatch;
import de.fmk.kicknrush.service.bean.MatchInfo;


public final class MatchInfoFactory
{
	private static MatchInfoFactory instance;


	private MatchInfoFactory() {}


	public static MatchInfoFactory getInstance()
	{
		if (instance == null)
			instance = new MatchInfoFactory();

		return instance;
	}


	public MatchInfo createMatchInfo(final DBMatch dbMatch)
	{
		final MatchInfo info;

		if (dbMatch == null)
			throw new IllegalArgumentException("The database match object must not be null.");

		info = new MatchInfo();
		info.setMatchID(dbMatch.getMatchID());
		info.setFinished(dbMatch.isFinished());
		info.setBeginUTC(dbMatch.getMatchDateTimeUTC());
		info.setCity(dbMatch.getLocation().getCity());
		info.setStadium(dbMatch.getLocation().getStadium());

		if (dbMatch.getGoals() == null || dbMatch.getGoals().length == 0)
		{
			info.setGoalsHome(0);
			info.setGoalsGuest(0);
		}
		else
		{
			final DBGoal goal = dbMatch.getGoals()[dbMatch.getGoals().length - 1];

			info.setGoalsHome(goal.getScoreHome());
			info.setGoalsGuest(goal.getScoreGuest());
		}

		return info;
	}
}
