package com.challenge.webchat.controller.user;

import com.challenge.webchat.business.user.UserBusiness;
import com.challenge.webchat.commons.User;
import com.challenge.webchat.controller.user.converter.UserDTOToUser;
import com.challenge.webchat.controller.user.dto.UserDTO;
import com.challenge.webchat.security.service.SecurityService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private UserDTOToUser userDTOToUser;

    @Autowired
    private UserBusiness userBusiness;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public ResponseEntity getUser(@PathVariable("username") String username) {
        User user = userBusiness.getBy(username);
        LOGGER.info("Found user with success");
        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity signUp(@RequestBody UserDTO userDTO) {
        LOGGER.info(String.format("POST to persist user: %s", userDTO));
        userBusiness.signUp(userDTOToUser.convert(userDTO));
        securityService.autoLogin(userDTO.getName(), userDTO.getPassword());
        return ResponseEntity.ok().build();
    }
}
