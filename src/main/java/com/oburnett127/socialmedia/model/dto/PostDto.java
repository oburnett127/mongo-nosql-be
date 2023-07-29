package com.oburnett127.socialmedia.model.dto;

import org.bson.types.ObjectId;

import lombok.*;

@Data
@AllArgsConstructor
public class PostDto {
        private ObjectId postId;
        private ObjectId authorUserId;
        private ObjectId profileUserId;
        private String text;
}