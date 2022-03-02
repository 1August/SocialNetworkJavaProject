package com.example.socialnetwork.services;

import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendshipService {
    @Autowired
    UserRepository userRepository;

    public void requestToAdd(Integer userId, String requestedUserEmail){
        User user = userRepository.getUserById(userId);
        User requestedUser = userRepository.getUserByEmail(requestedUserEmail);

        user.getRequestedFriends().add(requestedUser);
        requestedUser.getIncomeFriends().add(user);

        userRepository.save(user);
        userRepository.save(requestedUser);
    }

    public void addFriend(Integer userId, Integer friendId) throws Exception {
        if (userId == null || friendId == null) throw new Exception("User is null");
        if (userId.equals(friendId)) throw new Exception("Can not add same user");

        User user = userRepository.getUserById(userId);
        User friend = userRepository.getUserById(friendId);
        user.addFriend(friend);

        userRepository.save(user);
        userRepository.save(friend);
    }
}
