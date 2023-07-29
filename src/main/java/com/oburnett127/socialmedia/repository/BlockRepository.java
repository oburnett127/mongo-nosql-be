package com.oburnett127.socialmedia.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import com.oburnett127.socialmedia.model.Block;
import org.bson.types.ObjectId;

public interface BlockRepository extends MongoRepository<Block, ObjectId> {

    List<Block> findByBlockerId(@Param("blockerUserId") ObjectId blockerUserId);

    Optional<Block> findByBlockerUserIdAndBlockedUserId(@Param("blockerUserId") ObjectId blockerUserId,
                                                 @Param("blockedUserId") ObjectId blockedUserId);
    
}
