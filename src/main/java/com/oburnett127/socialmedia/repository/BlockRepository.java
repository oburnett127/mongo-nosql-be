package com.oburnett127.socialmedia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.oburnett127.socialmedia.model.Block;

public interface BlockRepository extends JpaRepository<Block, Integer> {

    @Query(value = "SELECT b FROM Block b WHERE b.blockerUserId = :blockerUserId")
    List<Block> findByBlockerId(@Param("blockerUserId") int blockerUserId);

    Optional<Block> findByBlockerUserIdAndBlockedUserId(@Param("blockerUserId") int blockerUserId,
                                                 @Param("blockedUserId") int blockedUserId);
    
}
