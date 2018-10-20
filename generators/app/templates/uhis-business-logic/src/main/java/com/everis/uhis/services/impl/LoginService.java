package com.everis.uhis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.everis.uhis.entities.AuthUserEntity;
import com.everis.uhis.model.AuthUserDto;
import com.everis.uhis.model.interfaces.IAuthUser;
import com.everis.uhis.repositories.IAuthUserRepository;
import com.everis.uhis.security.SecurityEncoder;
import com.everis.uhis.services.ILoginService;

@Service
public class LoginService implements ILoginService
{

    @Autowired
    private IAuthUserRepository authUserRepository;

    public LoginService()
    {
        super();
    }

    @Override
    public IAuthUser login(String username, String password)
    {
        AuthUserDto authUserDto;
        AuthUserEntity authUserInDatabase;
        String salt;
        String passwordHash;
        boolean checkPassword;

        authUserInDatabase = authUserRepository.findByUsername(username);
        if(authUserInDatabase == null) {
        	throw new BadCredentialsException("Not exist user in database");
        }
        

        salt = authUserInDatabase.getSalt();
        passwordHash = authUserInDatabase.getPassword();

        checkPassword = SecurityEncoder.checkSaltedPassword(password, salt, passwordHash);

        if (checkPassword)
        {
            authUserDto = new AuthUserDto(authUserInDatabase);
        }
        else
        {
            throw new BadCredentialsException("Bad Credentials");
        }

        return authUserDto;
    }

    @Override
    public IAuthUser findMe(String username)
    {
        AuthUserEntity authUserEntity;
        AuthUserDto authUserDto;

        authUserEntity = authUserRepository.findByUsername(username);
        authUserDto = new AuthUserDto(authUserEntity);

        return authUserDto;
    }

}
