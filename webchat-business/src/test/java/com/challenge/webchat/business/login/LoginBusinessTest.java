package com.challenge.webchat.business.login;

import com.challenge.webchat.business.config.BusinessConfig;
import com.challenge.webchat.commons.User;
import com.challenge.webchat.commons.builder.UserBuilder;
import com.challenge.webchat.repository.login.LoginRepository;
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
    private static final Long USER_ID = 1L;

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

        when(loginRepository.findBy(anyString(), anyString())).thenReturn(new UserBuilder()
                .withId(USER_ID).withName(USERNAME).withPassword(PASSWORD).getUser());

        User user = loginBusiness.getUserBy(USERNAME, PASSWORD);

        assertThat(user.getId(), is(USER_ID));
    }
}
