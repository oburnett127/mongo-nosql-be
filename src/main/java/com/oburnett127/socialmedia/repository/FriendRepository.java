package com.oburnett127.socialmedia.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oburnett127.socialmedia.model.Friend;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
    @Query(value = "SELECT * FROM friend WHERE from_user_id = :userId OR to_user_id = :userId")
    List<Friend> findByUserId(int userId);
}
