package com.challenge.webchat.repository.user.facade;

import com.challenge.webchat.repository.entity.UserEntity;
import com.challenge.webchat.repository.user.UserRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class UserRepositoryFacade {

    private static final Logger LOGGER = LogManager.getLogger(UserRepositoryFacade.class);

    @Autowired
    private UserRepository userRepository;

    public void updateLoggedInBy(String username, boolean isLoggedIn) {
        LOGGER.info(String.format("Changing in UserEntity %s with LoggedIn %s", username, isLoggedIn));
        UserEntity userEntity = userRepository.findByName(username);
        userEntity.setLoggedIn(isLoggedIn);
        userRepository.save(userEntity);
    }

    public void addFriend(String username, String newFriend) {
        LOGGER.info(String.format("Adding in UserEntity %s the friend %s", username, newFriend));
        UserEntity userEntity = userRepository.findByName(username);
        userEntity.getFriends().add(newFriend);
        userRepository.save(userEntity);
    }

    public void addOfflineMessage(String sender, String receiver, String message) {
        LOGGER.info(String.format("Adding message to %s from %s", receiver, sender));
        UserEntity userEntity = userRepository.findByName(receiver);
        Map<String, List<String>> offLineMessagesBySender = userEntity.getOffLineMessagesBySender();
        if (offLineMessagesBySender.containsKey(sender)) {
            offLineMessagesBySender.get(sender).add(message);
            userRepository.save(userEntity);
            return;
        }
        offLineMessagesBySender.put(sender, Collections.singletonList(message));
        userRepository.save(userEntity);
    }
}
