package com.oburnett127.socialmedia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.oburnett127.socialmedia.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "SELECT * FROM comment WHERE post_id = :postId")
    List<Comment> findByPostId(int postId);
}
