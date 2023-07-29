package com.oburnett127.socialmedia.model;

import lombok.*;

import org.bson.types.ObjectId;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "friend")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId friendId;
    @Basic(optional = false)
    private ObjectId fromUserId;
    @Basic(optional = false)
    private ObjectId toUserId;
    @Basic(optional = false)
    private FriendStatus status;
}