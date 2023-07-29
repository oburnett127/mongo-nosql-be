package com.oburnett127.socialmedia.model.request;

import org.bson.types.ObjectId;

import lombok.Data;

@Data
public class PostCreateRequest {
    private ObjectId authorUserId;
    private ObjectId profileUserId;
    private String text;
}
