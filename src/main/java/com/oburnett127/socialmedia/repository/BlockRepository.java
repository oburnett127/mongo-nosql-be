package com.oburnett127.socialmedia.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oburnett127.socialmedia.model.Block;
import com.oburnett127.socialmedia.model.Friend;

public interface BlockRepository extends JpaRepository<Block, Integer> {
    @Query(value = "SELECT * FROM block WHERE blocker_id = :blockerId")
    List<Block> findByBlockerId(int blockerId);
}
