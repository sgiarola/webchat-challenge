package com.challenge.webchat.repository.entity.builder;

import com.challenge.webchat.repository.entity.UserEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public class UserEntityBuilder {

    private UserEntity userEntity;

    public UserEntityBuilder() {
        this.userEntity = new UserEntity();
    }

    public UserEntityBuilder withId() {
        userEntity.setId(ObjectId.get());
        return this;
    }

    public UserEntityBuilder withName(String name) {
        userEntity.setName(name);
        return this;
    }

    public UserEntityBuilder withPassword(String password) {
        userEntity.setPassword(password);
        return this;
    }

    public UserEntityBuilder withAge(Integer age) {
        userEntity.setAge(age);
        return this;
    }

    public UserEntityBuilder withGenre(String genre) {
        userEntity.setGenre(genre);
        return this;
    }

    public UserEntityBuilder withEmail(String email) {
        userEntity.setEmail(email);
        return this;
    }

    public UserEntityBuilder withLoggedIn(boolean loggedIn) {
        userEntity.setLoggedIn(loggedIn);
        return this;
    }

    public UserEntityBuilder withFriends(List<String> friends) {
        userEntity.setFriends(friends);
        return this;
    }

    public UserEntityBuilder withOffLineMessagesBySender(Map<String, List<String>> offLineMessagesBySender) {
        userEntity.setOffLineMessagesBySender(offLineMessagesBySender);
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }
}
