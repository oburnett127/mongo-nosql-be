package com.oburnett127.socialmedia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.oburnett127.socialmedia.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(int userId);
}
