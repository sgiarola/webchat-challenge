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

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class UserRepositoryIntegrationTest {

    private static final String USERNAME = "fulano";
    private static final String PASSWORD = "123456";
    private static final String EMAIL = "fulano@org.com";
    private static final String GENRE = "M";

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

    @After
    public void delete() {
        userRepository.delete(userEntity);
    }
}
