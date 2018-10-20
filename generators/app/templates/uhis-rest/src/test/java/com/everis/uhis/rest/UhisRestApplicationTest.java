package com.everis.uhis.rest;

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

import com.everis.uhis.entities.AuthUserEntity;
import com.everis.uhis.initializer.UhisRestApplication;
import com.everis.uhis.model.interfaces.IAuthUser;
import com.everis.uhis.repositories.IAuthUserRepository;
import com.everis.uhis.services.impl.LoginService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { UhisRestApplication.class })
@WebAppConfiguration
@AutoConfigureMockMvc
public class UhisRestApplicationTest
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
