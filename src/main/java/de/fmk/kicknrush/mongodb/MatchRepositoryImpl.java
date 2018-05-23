package de.fmk.kicknrush.mongodb;

import com.mongodb.client.result.UpdateResult;
import de.fmk.kicknrush.mongodb.bean.DBMatch;
import de.fmk.kicknrush.mongodb.bean.UserBet;
import de.fmk.kicknrush.util.MatchUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


@Repository
public class MatchRepositoryImpl implements MatchRepositoryCustom
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MatchRepositoryImpl.class);

	private static final String BETS        = "userBets";
	private static final String BETS_USERID = "userBets.userID";
	private static final String ID          = "_id";

	@Autowired
	private MongoTemplate template;


	@Override
	public boolean setBet(String matchID, UserBet bet)
	{
		final Query        query;
		final Update       update;
		final UpdateResult result;

		query  = Query.query(Criteria.where(ID).is(matchID));
		update = new Update().push(BETS, bet);
		result = template.updateFirst(query, update, DBMatch.class);

		return result.getModifiedCount() == 1;
	}


	@Override
	public boolean removeBet(String matchID, String userID)
	{
		final DBMatch      foundMatch;
		final Query        query;
		final Update       update;
		final UpdateResult result;
		final UserBet      bet;

		foundMatch = template.findOne(Query.query(Criteria.where(ID).is(matchID)
		                                                  .and(BETS_USERID).is(userID)), DBMatch.class);

		if (foundMatch == null)
		{
			LOGGER.info("No bet was found for matchID '{}' and userID '{}'.", matchID, userID);
			return true;
		}

		bet = MatchUtil.getInstance().extractBetForUser(foundMatch, userID);

		if (bet == null)
		{
			LOGGER.info("No bet was found for user with id '{}' in match with id '{}'.", userID, matchID);
			return true;
		}

		query  = Query.query(Criteria.where(ID).is(matchID).and(BETS_USERID).is(userID));
		update = new Update().pull(BETS, new UserBet(1, 2, userID));
		result = template.updateMulti(query, update, DBMatch.class);

		return result.getModifiedCount() == 1;
	}
}
