package com.oburnett127.socialmedia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.oburnett127.socialmedia.model.Friend;
import com.oburnett127.socialmedia.model.FriendStatus;
import com.oburnett127.socialmedia.model.User;
import com.oburnett127.socialmedia.model.request.RequestFriendRequest;
import com.oburnett127.socialmedia.service.FriendService;
import com.oburnett127.socialmedia.service.UserService;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendController {
    private final FriendService friendService;
    private final UserService userService;

    public FriendController(FriendService friendService, UserService userService) {
        this.friendService = friendService;
        this.userService = userService;
    }

    @GetMapping("/getbyuserid/{id}")
    public ResponseEntity<List<User>> getFriendsByUserId(@Validated @PathVariable String userId) {
        System.out.println("inside getFriendByUserId() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final List<Integer> friendUserIds = friendService.getFriendUserIds(Integer.parseInt(userId));
        final List<User> friendUsers = userService.getUsers(friendUserIds);
        return ResponseEntity.ok().body(friendUsers);
    }

    @PostMapping("/request")
    public ResponseEntity<Friend> requestFriend(@Validated @RequestBody RequestFriendRequest requestFriendRequest) throws IOException {
        System.out.println("inside requestFriend() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final Friend friend = Friend.builder()
                .fromUserId(requestFriendRequest.getFromUserId())
                .toUserId(requestFriendRequest.getToUserId())
                .status(FriendStatus.PENDING)
                .build();
        friendService.requestFriend(friend);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/accept")
    public ResponseEntity<Friend> acceptFriend(@Validated @PathVariable int friendId) throws IOException {
        System.out.println("inside acceptFriend() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        friendService.acceptFriend(friendId);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Friend> deleteFriend(@Validated @PathVariable int friendId) throws IOException {
        System.out.println("inside deleteFriend() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        friendService.deleteFriend(friendId);
        return ResponseEntity.ok().body(null);
    }
}