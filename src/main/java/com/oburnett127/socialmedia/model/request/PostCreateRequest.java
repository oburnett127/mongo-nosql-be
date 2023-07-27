package com.oburnett127.socialmedia.model.request;

import lombok.Data;

@Data
public class PostCreateRequest {
    private int authorUserId;
    private int profileUserId;
    private String text;
}
