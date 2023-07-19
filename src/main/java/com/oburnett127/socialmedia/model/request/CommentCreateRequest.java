package com.oburnett127.socialmedia.model.request;

import lombok.Data;

@Data
public class CommentCreateRequest {
    private int postId;
    private int userId;
    private String text;
}
