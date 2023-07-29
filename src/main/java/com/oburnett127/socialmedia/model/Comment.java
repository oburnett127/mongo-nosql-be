package com.oburnett127.socialmedia.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "comment")
public class Comment {
        @Id
        private ObjectId commentId;
        
        private ObjectId postId;
        
        private ObjectId userId;

        private String text;

        public Comment(ObjectId postId, ObjectId userId, String text) {
                this.postId = postId;
                this.userId = userId;
                this.text = text;
        }
}