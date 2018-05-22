package de.fmk.kicknrush.mongodb;

import de.fmk.kicknrush.mongodb.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String>
{
}
