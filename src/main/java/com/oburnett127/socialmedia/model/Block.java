package com.oburnett127.socialmedia.model;

import lombok.*;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.bson.types.ObjectId;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "block")
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId blockId;
    @Basic(optional = false)
    private ObjectId blockerUserId;
    @Basic(optional = false)
    private ObjectId blockedUserId;

    // public Block(ObjectId blockerUserId, ObjectId blockedUserId) {
    //     this.blockerUserId = blockerUserId;
    //     this.blockedUserId = blockedUserId;
    // }
}