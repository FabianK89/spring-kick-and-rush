package de.fmk.kicknrush.mongodb;


import de.fmk.kicknrush.mongodb.bean.DBMatch;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


/**
 * { matchDateTimeUTC: {'$regex': '2017-08-18T[0-9]{2}:[0-9]{2}:[0-9]{2}Z'} }
 */
public interface MatchRepository extends MongoRepository<DBMatch, String>
{
	DBMatch findByMatchID(long p_matchID);

	List<DBMatch> findByLeagueParam(String p_leagueParam);
}
