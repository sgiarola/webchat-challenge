package com.challenge.webchat.controller.rest.login;

import com.challenge.webchat.commons.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    @RequestMapping(method = RequestMethod.GET)
    public User login() {
        LOGGER.debug("Get user authenticated");
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
