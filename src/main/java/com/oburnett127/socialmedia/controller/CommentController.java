// package com.oburnett127.socialmedia.controller;

// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.*;
// import com.oburnett127.socialmedia.model.Friend;
// import com.oburnett127.socialmedia.model.request.FriendCreateRequest;
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

//     @GetMapping("/list")
//     public ResponseEntity<List<Friend>> view() {
//         final var result = service.listAll();
//         return ResponseEntity.ok().body(result);
//     }

//     @GetMapping("/getbyid/{id}")
//     public ResponseEntity<Friend> getFriendById(@Validated @PathVariable String id) {
//         System.out.println("inside getFriendById() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
//         final var friend = service.getFriendById(Integer.parseInt(id));
//         return ResponseEntity.ok().body(friend);
//     }

//     @PostMapping("/create")
//     public ResponseEntity<Friend> createFriend(@Validated @RequestBody FriendCreateRequest friendCreateRequest) throws IOException {
//         System.out.println("inside createFriend() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
//         final var friend = Friend.builder()
//                 .name(friendCreateRequest.getName())
//                 .build();
//         service.createFriend(friend);
//         return ResponseEntity.ok(friend);
//     }

//     @PostMapping("/delete/{id}")
//     public ResponseEntity<Friend> deleteFriend(@Validated @PathVariable int id) throws IOException {
//         System.out.println("inside deleteFriend() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
//         service.deleteFriend(id);
//         return ResponseEntity.ok().body(null);
//     }
// }