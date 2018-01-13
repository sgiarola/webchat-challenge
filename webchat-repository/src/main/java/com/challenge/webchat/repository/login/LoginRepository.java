package com.challenge.webchat.repository.login;

import com.challenge.webchat.repository.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<UserEntity, String> {

    UserEntity findByNameAndPassword(String name, String password);
}
