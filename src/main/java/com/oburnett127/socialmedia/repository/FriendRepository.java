package com.oburnett127.socialmedia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.oburnett127.socialmedia.model.Friend;

public interface FriendRepository extends JpaRepository<Friend, Integer> {

    @Query("SELECT f FROM Friend f WHERE f.fromUserId = :fromUserId")
    List<Friend> findByFromUserId(@Param("fromUserId") int fromUserId);

    @Query("SELECT f FROM Friend f WHERE f.toUserId = :toUserId")
    List<Friend> findByToUserId(@Param("toUserId") int toUserId);

    Friend findByFromUserIdAndToUserId(int fromUserId, int toUserId);
}

