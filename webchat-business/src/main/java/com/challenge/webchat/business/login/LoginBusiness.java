package com.challenge.webchat.business.login;

import com.challenge.webchat.commons.User;
import com.challenge.webchat.repository.login.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginBusiness {

    @Autowired
    private LoginRepository loginRepository;

    public User getUserBy(String login, String password) {
        return loginRepository.findBy(login, password);
    }
}
