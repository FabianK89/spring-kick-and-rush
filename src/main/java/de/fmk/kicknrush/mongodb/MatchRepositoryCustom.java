package de.fmk.kicknrush.mongodb;


import de.fmk.kicknrush.mongodb.bean.UserBet;
import de.fmk.kicknrush.util.Status;
import de.fmk.kicknrush.service.bean.Bet;

import java.util.List;


public interface MatchRepositoryCustom
{
	Status setBet(String matchID, UserBet bet);

	Status removeBet(String matchID, String userID);

	List<Bet> getAllBetsForMatch(String matchID, String userID);
}
