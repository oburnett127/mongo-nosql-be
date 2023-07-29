package com.oburnett127.socialmedia.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection = "friend")
public class Friend {
    @Id
    private ObjectId friendId;

    private ObjectId fromUserId;
    
    private ObjectId toUserId;
    
    private FriendStatus status;
    
}