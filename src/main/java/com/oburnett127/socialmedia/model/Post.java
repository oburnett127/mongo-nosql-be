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
@Document(collection = "post")
public class Post {
        @Id
        private ObjectId postId;

        private ObjectId authorUserId;

        private ObjectId profileUserId;
        
        private String text;

        public Post(ObjectId authorUserId, ObjectId profileUserId, String text) {
                this.authorUserId = authorUserId;
                this.profileUserId = profileUserId;
                this.text = text;
        }
        
}