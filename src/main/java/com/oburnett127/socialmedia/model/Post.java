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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "post")
public class Post {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private int postId;
        @Basic(optional = false)
        private int authorUserId;
        @Basic(optional = false)
        private int profileUserId;
        @Basic(optional = false)
        private String text;

        public Post(int authorUserId, int profileUserId, String text) {
                this.authorUserId = authorUserId;
                this.profileUserId = profileUserId;
                this.text = text;
        }
}