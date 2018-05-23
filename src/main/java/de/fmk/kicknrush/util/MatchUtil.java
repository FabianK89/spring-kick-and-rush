package de.fmk.kicknrush.util;

import de.fmk.kicknrush.mongodb.bean.DBMatch;
import de.fmk.kicknrush.mongodb.bean.UserBet;


public final class MatchUtil
{
	private static MatchUtil instance;


	private MatchUtil() {}


	public static MatchUtil getInstance()
	{
		if (instance == null)
			instance = new MatchUtil();

		return instance;
	}


	public UserBet extractBetForUser(final DBMatch match, final String userID)
	{
		if (match == null || userID == null || userID.isEmpty())
			throw new IllegalArgumentException("The parameters of this method must not be null.");

		for (final UserBet userBet : match.getUserBets())
		{
			if (userID.equals(userBet.getUserID()))
				return userBet;
		}

		return null;
	}
}
