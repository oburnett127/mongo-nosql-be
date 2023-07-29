package com.oburnett127.socialmedia.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection = "block")
public class Block {
    @Id
    private ObjectId id;

    private ObjectId blockerUserId;
    
    private ObjectId blockedUserId;

    // public Block(ObjectId blockerUserId, ObjectId blockedUserId) {
    //     this.blockerUserId = blockerUserId;
    //     this.blockedUserId = blockedUserId;
    // }
}