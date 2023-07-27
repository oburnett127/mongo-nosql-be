package com.oburnett127.socialmedia.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class PostDto {
        private int postId;
        private int authorUserId;
        private int profileUserId;
        private String text;
}