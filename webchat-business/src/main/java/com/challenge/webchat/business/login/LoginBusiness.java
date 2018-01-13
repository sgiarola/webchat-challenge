package com.challenge.webchat.business.login;

import com.challenge.webchat.business.converter.UserEntityToUser;
import com.challenge.webchat.commons.User;
import com.challenge.webchat.repository.login.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginBusiness {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private UserEntityToUser userEntityToUser;

    public User getUserBy(String login, String password) {
        return userEntityToUser.convert(loginRepository.findByNameAndPassword(login, password));
    }
}
