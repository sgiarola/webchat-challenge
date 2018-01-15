package com.challenge.webchat.business.converter;

import com.challenge.webchat.commons.User;
import com.challenge.webchat.commons.builder.UserBuilder;
import com.challenge.webchat.repository.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUser implements Converter<UserEntity, User> {

    @Override
    public User convert(UserEntity userEntity) {

        return new UserBuilder().withId(userEntity.getId().toHexString()).withName(userEntity.getName())
                .withPassword(userEntity.getPassword()).withAge(userEntity.getAge()).withEmail(userEntity.getEmail())
                .withGenre(userEntity.getGenre()).withLoggedIn(userEntity.isLoggedIn()).getUser();
    }
}
