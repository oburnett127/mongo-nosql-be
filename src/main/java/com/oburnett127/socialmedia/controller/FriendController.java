// package com.oburnett127.socialmedia.controller;

// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.*;
// import com.oburnett127.socialmedia.model.Friend;
// import com.oburnett127.socialmedia.model.FriendStatus;
// import com.oburnett127.socialmedia.model.request.RequestFriendRequest;
// import com.oburnett127.socialmedia.service.FriendService;

// import java.io.IOException;
// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/friend")
// public class FriendController {
//     private final FriendService service;

//     public FriendController(FriendService service) {
//         this.service = service;
//     }

//     @GetMapping("/getbyuserid/{id}")
//     public ResponseEntity<List<Friend>> getFriendsByUserId(@Validated @PathVariable String userId) {
//         System.out.println("inside getFriendByUserId() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
//         final List<Friend> friends = service.getFriendsByUserId(Integer.parseInt(userId));
//         return ResponseEntity.ok().body(friends);
//     }

//     @PostMapping("/request")
//     public ResponseEntity<Friend> requestFriend(@Validated @RequestBody RequestFriendRequest requestFriendRequest) throws IOException {
//         System.out.println("inside requestFriend() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
//         final Friend friend = Friend.builder()
//                 .fromUserId(requestFriendRequest.getFromUserId())
//                 .toUserId(requestFriendRequest.getToUserId())
//                 .status(FriendStatus.PENDING)
//                 .build();
//         service.requestFriend(friend);
//         return ResponseEntity.ok(null);
//     }

//     @PostMapping("/accept")
//     public ResponseEntity<Friend> acceptFriend(@Validated @PathVariable int friendId) throws IOException {
//         System.out.println("inside acceptFriend() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
//         service.acceptFriend(friendId);
//         return ResponseEntity.ok(null);
//     }

//     @PostMapping("/delete/{id}")
//     public ResponseEntity<Friend> deleteFriend(@Validated @PathVariable int friendId) throws IOException {
//         System.out.println("inside deleteFriend() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
//         service.deleteFriend(friendId);
//         return ResponseEntity.ok().body(null);
//     }
// }