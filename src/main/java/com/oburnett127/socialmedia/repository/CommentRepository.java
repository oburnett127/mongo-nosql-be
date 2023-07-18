package com.oburnett127.socialmedia.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.oburnett127.socialmedia.model.Comment;
import com.oburnett127.socialmedia.model.Friend;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Optional<Friend> findByName(String name);
}
