package com.challenge.webchat.repository.user.facade;

import com.challenge.webchat.repository.config.RepositoryConfig;
import com.challenge.webchat.repository.entity.UserEntity;
import com.challenge.webchat.repository.entity.builder.UserEntityBuilder;
import com.challenge.webchat.repository.user.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class UserRepositoryFacadeIntegrationTest {

    private static final String USERNAME = "fulano";
    private static final String FRIEND_USERNAME = "cicrano";
    private static final String PASSWORD = "123456";
    private static final String EMAIL = "fulano@org.com";
    private static final String GENRE = "M";

    @Autowired
    private UserRepositoryFacade userRepositoryFacade;

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
    public void withLoggedOutUserWhenTurnToTrueInDatabaseThenReturnTrueInLoggedIn() {

        userRepositoryFacade.updateLoggedInBy(USERNAME, Boolean.TRUE);

        UserEntity userEntity = userRepository.findByName(USERNAME);

        assertTrue(userEntity.isLoggedIn());
    }

    @Test
    public void withThatHasNoFriendsWhenAddOneFriendThenReturnNotEmptyList() {

        userRepositoryFacade.addFriend(USERNAME, FRIEND_USERNAME);

        UserEntity userEntity = userRepository.findByName(USERNAME);

        assertThat(userEntity.getFriends(), is(not(empty())));
    }

    @After
    public void delete() {
        userRepository.delete(userEntity);
    }
}
