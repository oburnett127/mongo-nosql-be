package com.oburnett127.socialmedia.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import com.oburnett127.socialmedia.model.Friend;
import com.oburnett127.socialmedia.model.FriendStatus;
import com.oburnett127.socialmedia.repository.FriendRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FriendService {
    private final FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @SneakyThrows
    public List<Integer> getFriendUserIds(int userId) {
        List<Friend> friendRecs = friendRepository.findByFromUserId(userId);
        friendRecs.addAll(friendRepository.findByToUserId(userId));

        List<Integer> friendUserIds = friendRecs.stream()
                                .filter(friend -> friend.getFromUserId() == userId && friend.getStatus() == FriendStatus.FRIEND)
                                .map(friend -> friend.getToUserId())
                                .collect(Collectors.toList());

        List<Integer> friendFromUserIds = friendRecs.stream()
                                .filter(friend -> friend.getToUserId() == userId && friend.getStatus() == FriendStatus.FRIEND)
                                .map(friend -> friend.getFromUserId())
                                .collect(Collectors.toList());

        friendUserIds.addAll(friendFromUserIds);

        return friendUserIds;
    }

    @SneakyThrows
    public List<Integer> getOutgoingRequestsByUserId(int fromUserId) {
        List<Friend> friendRecs = friendRepository.findByFromUserId(fromUserId);

        return  friendRecs.stream()
                    .filter(friend -> friend.getStatus() == FriendStatus.PENDING)
                    .map(friend -> friend.getToUserId())
                    .collect(Collectors.toList());
    }

    @SneakyThrows
    public List<Integer> getIncomingRequestsByUserId(int toUserId) {
        List<Friend> friendRecs = friendRepository.findByToUserId(toUserId);

        return  friendRecs.stream()
                    .filter(friend -> friend.getStatus() == FriendStatus.PENDING)
                    .map(friend -> friend.getFromUserId())
                    .collect(Collectors.toList());
    }

    @SneakyThrows
    public void requestFriend(Friend friend) {
        friendRepository.save(friend);   
    }

    @SneakyThrows
    public void acceptFriend(int friendId) {
        Optional<Friend> friendOpt = friendRepository.findById(friendId);
        if(friendOpt.isPresent()) {
            Friend friend = friendOpt.get();
            friend.setStatus(FriendStatus.FRIEND);
            friendRepository.save(friend);
        }
    }

    @SneakyThrows
    public void deleteFriend(int friendId) {
        friendRepository.deleteById(friendId);
    }
}