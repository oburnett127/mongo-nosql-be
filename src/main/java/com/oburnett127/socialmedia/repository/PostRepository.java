package com.oburnett127.socialmedia.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.oburnett127.socialmedia.model.Post;
import org.bson.types.ObjectId;

public interface PostRepository extends MongoRepository<Post, ObjectId> {

    List<Post> findByAuthorUserId(ObjectId userId);

    List<Post> findByProfileUserId(ObjectId profileUserId);

}
