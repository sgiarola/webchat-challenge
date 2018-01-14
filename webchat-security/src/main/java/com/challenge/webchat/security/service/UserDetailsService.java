package com.challenge.webchat.security.service;

import com.challenge.webchat.repository.entity.UserEntity;
import com.challenge.webchat.repository.user.UserRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private static final Logger LOGGER = LogManager.getLogger(UserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByName(username);
        LOGGER.info(String.format("Found registered user with ID: %s to authenticate", user.getId()));
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), AuthorityUtils.NO_AUTHORITIES);
    }
}
