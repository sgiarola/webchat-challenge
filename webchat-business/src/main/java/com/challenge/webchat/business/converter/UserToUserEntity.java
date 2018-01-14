package com.challenge.webchat.business.converter;

import com.challenge.webchat.commons.User;
import com.challenge.webchat.repository.entity.UserEntity;
import com.challenge.webchat.repository.entity.builder.UserEntityBuilder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserToUserEntity implements Converter<User, UserEntity> {

    @Override
    public UserEntity convert(User user) {

        return new UserEntityBuilder().withName(user.getName())
                .withPassword(new BCryptPasswordEncoder().encode(user.getPassword())).withAge(user.getAge()).withEmail(user.getEmail())
                .withGenre(user.getGenre()).getUserEntity();
    }
}
