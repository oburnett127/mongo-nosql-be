package com.oburnett127.socialmedia.model.request;

import org.bson.types.ObjectId;

import lombok.Data;

@Data
public class RequestFriendRequest {
  private ObjectId fromUserId;
  private ObjectId toUserId;
}
