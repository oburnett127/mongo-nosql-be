package com.oburnett127.socialmedia.model.request;

import lombok.Data;

@Data
public class DeleteFriendRequest {
  private int userId1;
  private int userId2;
}
