package com.oburnett127.socialmedia.model;

import lombok.*;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "friend")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int friendId;
    @Basic(optional = false)
    private int fromUserId;
    @Basic(optional = false)
    private int toUserId;
    @Basic(optional = false)
    private FriendStatus status;

    public Friend(int fromUserId, int toUserId) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.status = FriendStatus.PROPOSED;
    }
}