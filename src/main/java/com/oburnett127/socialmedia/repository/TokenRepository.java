package com.oburnett127.socialmedia.repository;

import com.oburnett127.socialmedia.model.Token;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
import java.util.Optional;

public interface TokenRepository extends MongoRepository<Token, ObjectId> {

    @Query("{'user.id': ?0, $or: [{'expired': false}, {'revoked': false}]}")
    List<Token> findAllValidTokenByUserId(ObjectId userId);

    Optional<Token> findByToken(String token);
}
