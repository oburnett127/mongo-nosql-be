package com.oburnett127.socialmedia.service;

import lombok.SneakyThrows;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import com.oburnett127.socialmedia.model.Friend;
import com.oburnett127.socialmedia.model.FriendStatus;
import com.oburnett127.socialmedia.model.request.FriendStatusRequest;
import com.oburnett127.socialmedia.model.request.RequestFriendRequest;
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
    public boolean getFriendStatus(FriendStatusRequest friendStatusRequest) {
        //System.out.println("getFriendStatus method start: loggedInUID: " + friendStatusRequest.getLoggedInUserId()
        // + " otherUID: " + friendStatusRequest.getOtherUserId());

        Optional<Friend> friend = friendRepository.findByFromUserIdAndToUserId(friendStatusRequest.getLoggedInUserId(), 
                                                                                    friendStatusRequest.getOtherUserId());
        if(friend.isPresent() && friend.get().getStatus() == FriendStatus.FRIEND) return true;
        else {
            Optional<Friend> friendOpt = friendRepository.findByFromUserIdAndToUserId(friendStatusRequest.getOtherUserId(), 
                                                                                    friendStatusRequest.getLoggedInUserId());
            if(friendOpt.isPresent() && friendOpt.get().getStatus() == FriendStatus.FRIEND) return true;
            else return false;
        }
    }

    @SneakyThrows
    public List<ObjectId> getFriendUserIds(ObjectId userId) {
        List<Friend> friendRecs = friendRepository.findByFromUserId(userId);
        friendRecs.addAll(friendRepository.findByToUserId(userId));

        List<ObjectId> friendUserIds = friendRecs.stream()
                                .filter(friend -> friend.getFromUserId() == userId && friend.getStatus() == FriendStatus.FRIEND)
                                .map(friend -> friend.getToUserId())
                                .collect(Collectors.toList());

        List<ObjectId> friendFromUserIds = friendRecs.stream()
                                .filter(friend -> friend.getToUserId() == userId && friend.getStatus() == FriendStatus.FRIEND)
                                .map(friend -> friend.getFromUserId())
                                .collect(Collectors.toList());

        friendUserIds.addAll(friendFromUserIds);

        return friendUserIds;
    }

    @SneakyThrows
    public List<ObjectId> getOutgoingRequestsByUserId(ObjectId fromUserId) {
        List<Friend> friendRecs = friendRepository.findByFromUserId(fromUserId);

        return  friendRecs.stream()
                    .filter(friend -> friend.getStatus() == FriendStatus.PENDING)
                    .map(friend -> friend.getToUserId())
                    .collect(Collectors.toList());
    }

    @SneakyThrows
    public List<ObjectId> getIncomingRequestsByUserId(ObjectId toUserId) {
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
    public void acceptFriend(RequestFriendRequest requestFriendRequest) {
        ObjectId fromUserId = requestFriendRequest.getFromUserId();
        ObjectId toUserId = requestFriendRequest.getToUserId();
        Optional<Friend> friendOpt = friendRepository.findByFromUserIdAndToUserId(fromUserId, toUserId);
        if(friendOpt.isPresent()) {
            Friend friend = friendOpt.get();
            friend.setStatus(FriendStatus.FRIEND);
            friendRepository.save(friend);
        }
    }

    @SneakyThrows
    public void deleteFriend(ObjectId userId1, ObjectId userId2) {
        Optional<Friend> friendOpt = friendRepository.findByFromUserIdAndToUserId(userId1, userId2);

        if (friendOpt.isPresent()) {
            friendRepository.delete(friendOpt.get());
        } else {
            friendOpt = friendRepository.findByFromUserIdAndToUserId(userId2, userId1);
            if (friendOpt.isPresent()) {
                friendRepository.delete(friendOpt.get());
            }
        }
    }
}