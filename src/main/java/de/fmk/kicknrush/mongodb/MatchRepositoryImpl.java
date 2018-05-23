package de.fmk.kicknrush.mongodb;

import com.mongodb.client.result.UpdateResult;
import de.fmk.kicknrush.mongodb.bean.DBMatch;
import de.fmk.kicknrush.mongodb.bean.UserBet;
import de.fmk.kicknrush.service.bean.Bet;
import de.fmk.kicknrush.util.MatchUtil;
import de.fmk.kicknrush.util.Status;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Repository
public class MatchRepositoryImpl implements MatchRepositoryCustom
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MatchRepositoryImpl.class);

	@Autowired
	private MongoTemplate template;


	@Override
	public Status setBet(String matchID, UserBet bet)
	{
		final Query        query;
		final Update       update;
		final UpdateResult result;

		if (matchID == null || !ObjectId.isValid(matchID))
		{
			LOGGER.warn("'{}' is not a valid matchID. Request will be cancelled.", matchID);
			return Status.INVALID;
		}

		if (bet == null || !ObjectId.isValid(bet.getUserID()) || bet.getGoalsGuest() < 0 || bet.getGoalsHome() < 0)
		{
			LOGGER.warn("'{}' is not a valid bet object. Request will be cancelled.", bet == null ? null : bet.toString());
			return Status.INVALID;
		}

		query  = Query.query(Criteria.where(DBConstants.ID).is(matchID));
		update = new Update().push(DBConstants.BETS, bet);
		result = template.updateFirst(query, update, DBMatch.class);

		if (result.getModifiedCount() == 1)
			return Status.CREATED;

		return Status.DONE_NOTHING;
	}


	@Override
	public Status removeBet(String matchID, String userID)
	{
		final DBMatch      foundMatch;
		final Query        query;
		final Update       update;
		final UpdateResult result;
		final UserBet      bet;

		if (matchID == null || !ObjectId.isValid(matchID))
		{
			LOGGER.warn("'{}' is not a valid matchID. Request will be cancelled.", matchID);
			return Status.INVALID;
		}

		if (userID == null || !ObjectId.isValid(userID))
		{
			LOGGER.warn("'{}' is not a valid userID. Request will be cancelled.", userID);
			return Status.INVALID;
		}

		foundMatch = template.findOne(Query.query(Criteria.where(DBConstants.ID).is(matchID)
		                                                  .and(DBConstants.BETS_USERID).is(userID)), DBMatch.class);

		if (foundMatch == null)
		{
			LOGGER.info("No bet was found for matchID '{}' and userID '{}'.", matchID, userID);
			return Status.NOT_FOUND;
		}

		if (!MatchUtil.getInstance().bettingIsAllowed(foundMatch))
		{
			LOGGER.info("The match has already started. Betting is not allowed anymore.");
			return Status.REJECTED;
		}

		bet = MatchUtil.getInstance().extractBetForUser(foundMatch, userID);

		if (bet == null)
		{
			LOGGER.info("No bet was found for user with id '{}' in match with id '{}'.", userID, matchID);
			return Status.NOT_FOUND;
		}

		query  = Query.query(Criteria.where(DBConstants.ID).is(matchID).and(DBConstants.BETS_USERID).is(userID));
		update = new Update().pull(DBConstants.BETS, bet);
		result = template.updateMulti(query, update, DBMatch.class);

		if (result.getModifiedCount() == 1)
			return Status.DELETED;

		return Status.DONE_NOTHING;
	}


	@Override
	public List<Bet> getAllBetsForMatch(String matchID, String userID)
	{
		final DBMatch   foundMatch;
		final List<Bet> result;
		final Query     query;

		if (matchID == null || !ObjectId.isValid(matchID))
		{
			LOGGER.warn("'{}' is not a valid matchID. Request will be cancelled.", matchID);
			return Collections.emptyList();
		}

		if (userID == null || !ObjectId.isValid(userID))
		{
			LOGGER.warn("'{}' is not a valid userID. Request will be cancelled.", userID);
			return Collections.emptyList();
		}

		query      = Query.query(Criteria.where(DBConstants.ID).is(matchID));
		foundMatch = template.findOne(query, DBMatch.class);

		if (foundMatch == null)
			return Collections.emptyList();

		if (foundMatch.isFinished())
		{
			result = new ArrayList<>();

			for (final UserBet userBet : foundMatch.getUserBets())
				result.add(new Bet(userBet.getGoalsGuest(), userBet.getGoalsHome(), matchID, userBet.getUserID()));

			return result;
		}

		return Collections.emptyList();
	}
}
