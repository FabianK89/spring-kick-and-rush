package de.fmk.kicknrush.mongodb;


import de.fmk.kicknrush.mongodb.bean.UserBet;


public interface MatchRepositoryCustom
{
	boolean setBet(String matchID, UserBet bet);

	boolean removeBet(String matchID, String userID);
}
