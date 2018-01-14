package com.challenge.webchat.repository.user;

import com.challenge.webchat.repository.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {

    UserEntity findByName(String name);
}
