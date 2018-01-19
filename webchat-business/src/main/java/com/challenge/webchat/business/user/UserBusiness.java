package com.challenge.webchat.business.user;

import com.challenge.webchat.business.converter.UserEntityToUser;
import com.challenge.webchat.business.converter.UserToUserEntity;
import com.challenge.webchat.commons.User;
import com.challenge.webchat.commons.exception.BusinessException;
import com.challenge.webchat.repository.entity.UserEntity;
import com.challenge.webchat.repository.user.UserRepository;
import com.challenge.webchat.repository.user.facade.UserRepositoryFacade;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBusiness {

    private static final Logger LOGGER = LogManager.getLogger(UserBusiness.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryFacade userRepositoryFacade;

    @Autowired
    private UserEntityToUser userEntityToUser;

    @Autowired
    private UserToUserEntity userToUserEntity;

    public User getBy(String username) {
        LOGGER.info(String.format("Get user with username %s", username));
        UserEntity userEntity = userRepository.findByName(username);
        List<UserEntity> friendsEntities = userRepository.findByNameIn(userEntity.getFriends());
        User user = userEntityToUser.convert(userEntity);
        user.setFriends(userEntityToUser.convert(friendsEntities));
        return user;
    }

    public String signUp(User user) {
        UserEntity userEntity = userRepository.save(userToUserEntity.convert(user));
        LOGGER.info(String.format("Sign Up user with ID: %s", userEntity.getId().toHexString()));
        return userEntity.getId().toHexString();
    }

    public void addFriendTo(String username, String friend) {
        LOGGER.info(String.format("Add friend %s to user with username %s", friend, username));
        if (userRepository.findByName(friend) == null) {
            throw new BusinessException("Friend not found.");
        }
        userRepositoryFacade.addFriend(username, friend);
    }
}
