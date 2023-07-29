package com.oburnett127.socialmedia.model;

import lombok.*;

import org.bson.types.ObjectId;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "comment")
public class Comment {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private ObjectId commentId;
        @Basic(optional = false)
        private ObjectId postId;
        @Basic(optional = false)
        private ObjectId userId;
        @Basic(optional = false)
        private ObjectId text;

        public Comment(ObjectId postId, ObjectId userId, ObjectId text) {
                this.postId = postId;
                this.userId = userId;
                this.text = text;
        }
}