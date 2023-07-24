package com.oburnett127.socialmedia.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlockedStatusRequest {
    private int blockerUserId;
    private int blockedUserId;
}
