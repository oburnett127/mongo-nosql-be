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
@Table(name = "block")
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blockId;
    @Basic(optional = false)
    private int blockerUserId;
    @Basic(optional = false)
    private int blockedUserId;

    public Block(int blockerUserId, int blockedUserId) {
        this.blockerUserId = blockerUserId;
        this.blockedUserId = blockedUserId;
    }
}