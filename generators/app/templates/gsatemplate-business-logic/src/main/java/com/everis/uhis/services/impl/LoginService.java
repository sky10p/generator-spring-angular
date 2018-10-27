package com.everis.<%= appName %>.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.everis.<%= appName %>.entities.AuthUserEntity;
import com.everis.<%= appName %>.model.AuthUserDto;
import com.everis.<%= appName %>.model.interfaces.IAuthUser;
import com.everis.<%= appName %>.repositories.IAuthUserRepository;
import com.everis.<%= appName %>.security.SecurityEncoder;
import com.everis.<%= appName %>.services.ILoginService;

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
