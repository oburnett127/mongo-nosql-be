package com.oburnett127.socialmedia.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "token")
public class Token {
    @Id
    public ObjectId id;

    public String token;

    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    public User user; 

}
