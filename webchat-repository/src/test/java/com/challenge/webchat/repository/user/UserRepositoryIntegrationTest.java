package com.challenge.webchat.repository.user;

import com.challenge.webchat.repository.config.RepositoryConfig;
import com.challenge.webchat.repository.entity.UserEntity;
import com.challenge.webchat.repository.entity.builder.UserEntityBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class UserRepositoryIntegrationTest {

    private static final String USERNAME = "fulano";
    private static final String USERNAME_CICRANO = "cicrano";
    private static final String PASSWORD = "123456";
    private static final String EMAIL = "fulano@org.com";
    private static final String GENRE = "M";
    private static final int LIST_USERS_SIZE = 2;

    @Autowired
    private UserRepository userRepository;

    private UserEntity userEntity;

    @Before
    public void setUp() {

        userEntity = new UserEntityBuilder().withName(USERNAME).withPassword(PASSWORD)
                .withEmail(EMAIL).withGenre(GENRE).withLoggedIn(Boolean.FALSE).getUserEntity();
        userRepository.save(userEntity);
    }

    @Test
    public void withValidUsernameAndPasswordWhenSelectByBothParametersThenReturnCorrectUserEntity() {

        UserEntity userEntity = userRepository.findByName(USERNAME);

        assertThat(userEntity.getPassword(), is(PASSWORD));
    }

    @Test
    public void withListOfValidUsernamesWhenFindInDatabaseThenReturnListOfUserEntities() {

        UserEntity secondUserEntity = new UserEntityBuilder().withName(USERNAME_CICRANO).withPassword(PASSWORD)
                .withEmail(EMAIL).withGenre(GENRE).withLoggedIn(Boolean.FALSE).getUserEntity();

        userRepository.save(secondUserEntity);

        List<UserEntity> userEntities = userRepository.findByNameIn(Arrays.asList(USERNAME, USERNAME_CICRANO));

        userRepository.delete(secondUserEntity);

        assertThat(userEntities.size(), is(LIST_USERS_SIZE));
    }

    @After
    public void delete() {
        userRepository.delete(userEntity);
    }
}
