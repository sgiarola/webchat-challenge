package com.challenge.webchat.repository.login;

import com.challenge.webchat.repository.config.RepositoryConfig;
import com.challenge.webchat.repository.entity.UserEntity;
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
public class LoginRepositoryIntegrationTest {

    private static final String USERNAME = "fulano";
    private static final String PASSWORD = "123456";
    private static final String EMAIL = "fulano@org.com";
    private static final String GENRE = "M";

    @Autowired
    private LoginRepository loginRepository;

    @Before
    public void setUp() {

        loginRepository.save(createUserEntity());
    }

    @Test
    public void withValidUsernameAndPasswordWhenSelectByBothParametersThenReturnCorrectUserEntity() {

        UserEntity userEntity = loginRepository.findByNameAndPassword(USERNAME, PASSWORD);

        assertThat(userEntity.getPassword(), is(PASSWORD));
    }

    private UserEntity createUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(USERNAME);
        userEntity.setPassword(PASSWORD);
        userEntity.setEmail(EMAIL);
        userEntity.setGenre(GENRE);
        return userEntity;
    }
}
