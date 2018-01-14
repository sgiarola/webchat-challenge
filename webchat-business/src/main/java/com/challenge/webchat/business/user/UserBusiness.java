package com.challenge.webchat.business.user;

import com.challenge.webchat.business.converter.UserEntityToUser;
import com.challenge.webchat.commons.User;
import com.challenge.webchat.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusiness {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityToUser userEntityToUser;

    public User getUserBy(String login) {
        return userEntityToUser.convert(userRepository.findByName(login));
    }
}
