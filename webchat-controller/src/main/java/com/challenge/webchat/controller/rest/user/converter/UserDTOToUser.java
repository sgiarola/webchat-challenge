package com.challenge.webchat.controller.rest.user.converter;

import com.challenge.webchat.commons.User;
import com.challenge.webchat.commons.builder.UserBuilder;
import com.challenge.webchat.controller.rest.user.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDTOToUser implements Converter<UserDTO, User> {

    @Override
    public User convert(UserDTO userDTO) {

        return new UserBuilder().withName(userDTO.getName()).withPassword(userDTO.getPassword())
                .withAge(userDTO.getAge()).withEmail(userDTO.getEmail()).withGenre(userDTO.getGenre()).getUser();
    }
}
