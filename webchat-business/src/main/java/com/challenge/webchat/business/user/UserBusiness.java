package com.challenge.webchat.business.user;

import com.challenge.webchat.business.converter.UserEntityToUser;
import com.challenge.webchat.business.converter.UserToUserEntity;
import com.challenge.webchat.commons.User;
import com.challenge.webchat.repository.entity.UserEntity;
import com.challenge.webchat.repository.user.UserRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusiness {

    private static final Logger LOGGER = LogManager.getLogger(UserBusiness.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityToUser userEntityToUser;

    @Autowired
    private UserToUserEntity userToUserEntity;

    public User getBy(String login) {
        return userEntityToUser.convert(userRepository.findByName(login));
    }

    public String signUp(User user) {
        UserEntity userEntity = userRepository.save(userToUserEntity.convert(user));
        LOGGER.info(String.format("Sign Up user with ID: %s", userEntity.getId().toHexString()));
        return userEntity.getId().toHexString();
    }
}
