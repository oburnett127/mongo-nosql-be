package com.oburnett127.socialmedia.model.request;

import lombok.Data;

@Data
public class PostCreateRequest {
    private int userId;
    private String text;
}
