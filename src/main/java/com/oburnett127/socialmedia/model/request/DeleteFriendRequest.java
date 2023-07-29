package com.oburnett127.socialmedia.model.request;

import org.bson.types.ObjectId;

import lombok.Data;

@Data
public class DeleteFriendRequest {
  private ObjectId userId1;
  private ObjectId userId2;
}
