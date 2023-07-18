package com.oburnett127.socialmedia.model;

import lombok.*;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "comment")
public class Comment {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private int commentId;
        @Basic(optional = false)
        private int postId;
        @Basic(optional = false)
        private int userId;
        @Basic(optional = false)
        private String text;

        public Comment(int postId, int userId, String text) {
                this.postId = postId;
                this.userId = userId;
                this.text = text;
        }
}