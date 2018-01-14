package com.challenge.webchat.repository.user.facade;

import com.challenge.webchat.repository.entity.UserEntity;
import com.challenge.webchat.repository.user.UserRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
