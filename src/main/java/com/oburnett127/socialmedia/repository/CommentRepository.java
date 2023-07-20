package com.oburnett127.socialmedia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.oburnett127.socialmedia.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "SELECT c FROM Comment c WHERE c.postId = :postId")
    List<Comment> findByPostId(@Param("postId") int postId);
}
