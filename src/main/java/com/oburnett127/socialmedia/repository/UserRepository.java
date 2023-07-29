package com.oburnett127.socialmedia.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import com.oburnett127.socialmedia.model.User;
import org.bson.types.ObjectId;

public interface UserRepository extends MongoRepository<User, ObjectId> {
  
  Optional<User> findByEmail(ObjectId email);

  List<User> findByFirstNameAndLastName(@Param("firstName") ObjectId firstName, @Param("lastName") ObjectId lastName);

  List<User> findByFirstName(@Param("firstName") ObjectId firstName);
  
  List<User> findByLastName(@Param("lastName") ObjectId lastName);

}
