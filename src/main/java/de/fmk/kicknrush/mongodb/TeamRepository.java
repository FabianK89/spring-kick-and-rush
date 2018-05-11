package de.fmk.kicknrush.mongodb;

import de.fmk.kicknrush.mongodb.bean.DBTeam;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TeamRepository extends MongoRepository<DBTeam, String>
{
	DBTeam findByTeamID(long teamID);
}
