package com.everis.<%= appName %>.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.everis.<%= appName %>.entities.AuthUserEntity;
import com.everis.<%= appName %>.initializer.<%= appName_CamelCase %>RestApplication;
import com.everis.<%= appName %>.model.interfaces.IAuthUser;
import com.everis.<%= appName %>.repositories.IAuthUserRepository;
import com.everis.<%= appName %>.services.impl.LoginService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { <%= appName_CamelCase %>RestApplication.class })
@WebAppConfiguration
@AutoConfigureMockMvc
public class <%= appName_CamelCase %>RestApplicationTest
{

    @Mock
    private IAuthUserRepository authUserRepositoryMock;

    @InjectMocks
    private LoginService loginService;

    @Test
    public void testFindUser() throws Exception
    {
        AuthUserEntity authUserEntity = new AuthUserEntity("pablo", "e4d2f949a401c04e9cd0bd410e31d6f81b413974151fc458c18d2d186c379219", "salt");
        when(authUserRepositoryMock.findByUsername("pablo")).thenReturn(authUserEntity);

        IAuthUser login = loginService.login("pablo", "123456");

        assertEquals("Users should be the same", login.getUsername(), authUserEntity.getUsername());

    }

}
