package com.oburnett127.socialmedia.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import com.oburnett127.socialmedia.model.Comment;
import org.bson.types.ObjectId;

public interface CommentRepository extends MongoRepository<Comment, ObjectId> {
   
    List<Comment> findByPostId(@Param("postId") ObjectId postId);

}
