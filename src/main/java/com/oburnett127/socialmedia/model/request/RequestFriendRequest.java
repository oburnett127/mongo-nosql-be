package com.oburnett127.socialmedia.model.request;

import lombok.Data;

@Data
public class RequestFriendRequest {
  private int fromUserId;
  private int toUserId;
}
