package com.challenge.webchat.repository.user;

import com.challenge.webchat.repository.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, String> {

    UserEntity findByName(String name);

    List<UserEntity> findByNameIn(List<String> names);
}
