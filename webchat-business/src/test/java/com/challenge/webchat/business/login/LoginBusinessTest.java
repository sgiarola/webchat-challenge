package com.challenge.webchat.business.login;

import com.challenge.webchat.business.config.BusinessConfig;
import com.challenge.webchat.commons.User;
import com.challenge.webchat.repository.entity.UserEntity;
import com.challenge.webchat.repository.login.LoginRepository;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusinessConfig.class)
public class LoginBusinessTest {

    private static final String USERNAME = "fulano";
    private static final String PASSWORD = "123456";

    @Autowired
    @InjectMocks
    private LoginBusiness loginBusiness;

    @Mock
    private LoginRepository loginRepository;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void withValidLoginAndPasswordWhenCallRepositoryThenReturnCorrectUser() {

        ObjectId id = ObjectId.get();

        when(loginRepository.findByNameAndPassword(anyString(), anyString())).thenReturn(
                new UserEntity(id, USERNAME, PASSWORD));

        User user = loginBusiness.getUserBy(USERNAME, PASSWORD);

        assertThat(user.getId(), is(id.toHexString()));
    }
}
