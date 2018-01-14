package com.challenge.webchat.controller.login;

import com.challenge.webchat.controller.response.CustomResponse;
import com.challenge.webchat.controller.response.ResponseType;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            LOGGER.error("Username or Password is empty or null.");
            return ResponseEntity.badRequest().body(new CustomResponse("Your username or password is invalid.", ResponseType.DANGER));
        }

        LOGGER.info("Successfully login.");
        return ResponseEntity.ok().build();
    }
}
