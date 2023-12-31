package com.oburnett127.socialmedia.model.request;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlockedStatusRequest {
    private ObjectId blockerUserId;
    private ObjectId blockedUserId;
}
