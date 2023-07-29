package com.oburnett127.socialmedia.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import com.oburnett127.socialmedia.model.Friend;
import org.bson.types.ObjectId;

public interface FriendRepository extends MongoRepository<Friend, ObjectId> {

    List<Friend> findByFromUserId(@Param("fromUserId") ObjectId fromUserId);

    List<Friend> findByToUserId(@Param("toUserId") ObjectId toUserId);

    Optional<Friend> findByFromUserIdAndToUserId(@Param("fromUserId") ObjectId fromUserId, @Param("toUserId") ObjectId toUserId);
    
}

