package com.oburnett127.socialmedia.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.oburnett127.socialmedia.model.Block;
import com.oburnett127.socialmedia.model.Friend;

public interface BlockRepository extends JpaRepository<Block, Integer> {
    Optional<Friend> findByName(String name);
}
