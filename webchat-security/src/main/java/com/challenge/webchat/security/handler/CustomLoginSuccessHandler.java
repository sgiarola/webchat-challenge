package com.challenge.webchat.security.handler;


import com.challenge.webchat.repository.user.facade.UserRepositoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserRepositoryFacade userRepositoryFacade;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {

        Object userDetails = authentication.getPrincipal();
        if (userDetails instanceof UserDetails) {
            userRepositoryFacade.updateLoggedInBy(((UserDetails)userDetails).getUsername(), Boolean.TRUE);
        }
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }
}
