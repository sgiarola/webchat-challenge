package com.challenge.webchat.commons.builder;

import com.challenge.webchat.commons.User;

public class UserBuilder {

    private User user;

    public UserBuilder() {
        this.user = new User();
    }

    public UserBuilder withId(Long id) {
        user.setId(id);
        return this;
    }

    public UserBuilder withName(String name) {
        user.setName(name);
        return this;
    }

    public UserBuilder withPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public User getUser() {
        return user;
    }
}
