package com.oburnett127.socialmedia.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oburnett127.socialmedia.model.Friend;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
    Optional<Friend> findByName(String name);

    @Query(value = "SELECT COALESCE(MAX(id), 0) FROM Employer")
    int getMaxEmployerId();
}
