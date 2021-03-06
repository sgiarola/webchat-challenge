package com.challenge.webchat.controller.rest.user;

import com.challenge.webchat.business.user.UserBusiness;
import com.challenge.webchat.commons.User;
import com.challenge.webchat.controller.rest.user.converter.UserDTOToUser;
import com.challenge.webchat.controller.rest.user.dto.SuccessResponseDTO;
import com.challenge.webchat.controller.rest.user.dto.UserDTO;
import com.challenge.webchat.controller.rest.user.dto.UserFriendDTO;
import com.challenge.webchat.security.service.SecurityService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    public User getUser(@PathVariable("username") String username) {
        User user = userBusiness.getBy(username);
        LOGGER.info("Found user with success");
        return user;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponseDTO signUp(@RequestBody UserDTO userDTO) {
        LOGGER.info(String.format("POST to persist user: %s", userDTO));
        userBusiness.signUp(userDTOToUser.convert(userDTO));
        securityService.autoLogin(userDTO.getName(), userDTO.getPassword());
        return new SuccessResponseDTO("Created user with success", HttpStatus.OK.value());
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/friend")
    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    public SuccessResponseDTO addFriend(@RequestBody UserFriendDTO userFriendDTO) {
        LOGGER.info("PATCH to add friend");
        userBusiness.addFriendTo(userFriendDTO.getName(), userFriendDTO.getFriend());
        return new SuccessResponseDTO(String.format("Added friend %s with success.", userFriendDTO.getFriend()), HttpStatus.OK.value());
    }
}
