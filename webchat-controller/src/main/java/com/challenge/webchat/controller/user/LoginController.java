package com.challenge.webchat.controller.user;

import com.challenge.webchat.controller.response.CustomResponse;
import com.challenge.webchat.controller.response.ResponseType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return ResponseEntity.badRequest().body(new CustomResponse("Your username and password is invalid.", ResponseType.DANGER));
        }

        return ResponseEntity.ok().build();
    }
}
