package com.challenge.webchat.controller.rest.login;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    @RequestMapping(method = RequestMethod.GET)
    public UserDetails login() {
        LOGGER.debug("Get user authenticated");
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
