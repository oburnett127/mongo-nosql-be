package com.oburnett127.socialmedia.model.request;

import lombok.Data;

@Data
public class BlockCreateRequest {
    private int blockerUserId;
    private int blockedUserId;
}
