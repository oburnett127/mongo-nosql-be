// package com.oburnett127.socialmedia.service;

// import lombok.SneakyThrows;
// import org.springframework.stereotype.Service;
// import com.oburnett127.socialmedia.model.Friend;
// import com.oburnett127.socialmedia.model.User;
// import com.oburnett127.socialmedia.repository.FriendRepository;
// import java.util.List;
// import java.util.Optional;

// @Service
// public class FriendService {
//     private final FriendRepository friendRepository;

//     public FriendService(FriendRepository friendRepository) {
//         this.friendRepository = friendRepository;
//     }

//     @SneakyThrows
//     public List<Friend> getFriendsByUserId(int userId) {
//         return friendRepository.findByUserId(userId);
//     }

//     @SneakyThrows
//     public void requestFriend(Friend friend) {
//         friendRepository.save(friend);   
//     }

//     @SneakyThrows
//     public void acceptFriend(int friendId) {
//         Optional<Friend> friend = friendRepository.findById(friendId);
//         int friend = friend.get().getId();
//         Friend friend = new Friend(userId, friendText);
//         friendRepository.save(friend);   
//     }

//     @SneakyThrows
//     public void deleteFriend(int friendId) {
        
//     }


// }