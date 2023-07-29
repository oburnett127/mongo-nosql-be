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
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "post")
public class Post {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private ObjectId postId;
        @Basic(optional = false)
        private ObjectId authorUserId;
        @Basic(optional = false)
        private ObjectId profileUserId;
        @Basic(optional = false)
        private ObjectId text;

        public Post(ObjectId authorUserId, ObjectId profileUserId, ObjectId text) {
                this.authorUserId = authorUserId;
                this.profileUserId = profileUserId;
                this.text = text;
        }
}