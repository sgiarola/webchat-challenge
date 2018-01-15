package com.challenge.webchat.business.user;

import com.challenge.webchat.business.config.BusinessConfig;
import com.challenge.webchat.commons.User;
import com.challenge.webchat.commons.builder.UserBuilder;
import com.challenge.webchat.repository.entity.UserEntity;
import com.challenge.webchat.repository.entity.builder.UserEntityBuilder;
import com.challenge.webchat.repository.user.UserRepository;
import com.challenge.webchat.repository.user.facade.UserRepositoryFacade;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusinessConfig.class)
public class UserBusinessTest {

    private static final String USERNAME = "fulano";
    private static final String USERNAME_CICRANO = "cicrano";
    private static final String PASSWORD = "123456";
    private static final int FRIEND_LIST_SIZE = 1;

    @Autowired
    @InjectMocks
    private UserBusiness userBusiness;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserRepositoryFacade userRepositoryFacade;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void withValidLoginAndPasswordWhenCallRepositoryToFindThenReturnCorrectUser() {

        ObjectId id = ObjectId.get();

        when(userRepository.findByName(anyString())).thenReturn(new UserEntity(id, USERNAME));

        User user = userBusiness.getBy(USERNAME);

        assertThat(user.getId(), is(id.toHexString()));
    }

    @Test
    public void withValidUserWithOneFriendWhenCallRepositoryGetUserThenReturnFriendFilled() {

        when(userRepository.findByName(anyString())).thenReturn(new UserEntityBuilder().withId().withName(USERNAME)
                .withFriends(Collections.singletonList(USERNAME_CICRANO)).getUserEntity());

        when(userRepository.findByNameIn(anyList())).thenReturn(
                Collections.singletonList(new UserEntityBuilder().withId().withName(USERNAME_CICRANO).getUserEntity()));

        User user = userBusiness.getBy(USERNAME);

        assertThat(user.getFriends().size(), is(FRIEND_LIST_SIZE));
    }

    @Test
    public void withValidUserWhenCallRepositoryToPersistThenReturnCorrectId() {

        UserEntity userEntity = new UserEntityBuilder().withId().withName(USERNAME).getUserEntity();

        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);

        String id = userBusiness.signUp(new UserBuilder().withName(USERNAME).withPassword(PASSWORD).getUser());

        assertThat(userEntity.getId().toHexString(), is(id));
    }

    @Test
    public void withValidUsernameWhenAddFriendToHeThenPassWithSuccess() {

        doNothing().when(userRepositoryFacade).addFriend(anyString(), anyString());

        userBusiness.addFriendTo(USERNAME, USERNAME_CICRANO);

        verify(userRepositoryFacade, times(1)).addFriend(USERNAME, USERNAME_CICRANO);
    }
}
