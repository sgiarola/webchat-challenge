package com.challenge.webchat.controller.rest.user.dto.builder;

import com.challenge.webchat.controller.rest.user.dto.UserDTO;

public class UserDTOBuilder {

    private UserDTO userDTO;

    public UserDTOBuilder() {
        this.userDTO = new UserDTO();
    }

    public UserDTOBuilder withName(String name) {
        userDTO.setName(name);
        return this;
    }

    public UserDTOBuilder withPassword(String password) {
        userDTO.setPassword(password);
        return this;
    }

    public UserDTOBuilder withAge(Integer age) {
        userDTO.setAge(age);
        return this;
    }

    public UserDTOBuilder withGenre(String genre) {
        userDTO.setGenre(genre);
        return this;
    }

    public UserDTOBuilder withEmail(String email) {
        userDTO.setEmail(email);
        return this;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }
}
