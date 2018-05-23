package de.fmk.kicknrush.mongodb;

public final class DBConstants
{
	public static final String BETS        = "userBets";
	public static final String ID          = "_id";
	public static final String SEASON_DAY  = "Spieltag";
	public static final String USERID      = "userID";

	public static final String BETS_USERID = BETS.concat(".").concat(USERID);


	private DBConstants() {}
}
