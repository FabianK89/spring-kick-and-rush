package de.fmk.kicknrush.util;

import de.fmk.kicknrush.mongodb.bean.DBMatch;
import de.fmk.kicknrush.mongodb.bean.UserBet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;


public final class MatchUtil
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MatchUtil.class);

	private static MatchUtil instance;


	private MatchUtil() {}


	public static MatchUtil getInstance()
	{
		if (instance == null)
			instance = new MatchUtil();

		return instance;
	}


	public boolean bettingIsAllowed(final DBMatch match)
	{
		final DateFormat    utcFormat;
		final LocalDateTime matchStart;
		final LocalDateTime now;
		final ZoneId        zone;

		if (match == null)
			return false;

		if (match.isFinished())
			return false;

		zone      = ZoneId.of("UTC");
		utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		utcFormat.setTimeZone(TimeZone.getTimeZone(zone));

		now = LocalDateTime.now(zone);

		try
		{
			matchStart = LocalDateTime.ofInstant(utcFormat.parse(match.getMatchDateTimeUTC()).toInstant(), zone);
		}
		catch (ParseException pex)
		{
			LOGGER.error("An error occurred while parsing the date string '" + match.getMatchDateTimeUTC() + "'.", pex);
			return false;
		}

		if (now.isAfter(matchStart))
			return false;

		return true;
	}


	public UserBet extractBetForUser(final DBMatch match, final String userID)
	{
		if (match == null || userID == null || userID.isEmpty())
			return null;

		for (final UserBet userBet : match.getUserBets())
		{
			if (userID.equals(userBet.getUserID()))
				return userBet;
		}

		return null;
	}
}
