package com.oburnett127.socialmedia.model.request;

import org.bson.types.ObjectId;

import lombok.Data;

@Data
public class CommentCreateRequest {
    private ObjectId postId;
    private ObjectId userId;
    private ObjectId text;
}
