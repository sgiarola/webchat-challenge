package com.challenge.webchat.controller.user;

import com.challenge.webchat.business.user.UserBusiness;
import com.challenge.webchat.commons.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserBusiness userBusiness;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getUser(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        User user = userBusiness.getUserBy(username);
        return ResponseEntity.ok().body(user);
    }
}
