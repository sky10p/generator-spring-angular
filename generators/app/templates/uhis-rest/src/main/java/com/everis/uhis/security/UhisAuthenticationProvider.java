package com.everis.uhis.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.everis.uhis.model.interfaces.IAuthUser;
import com.everis.uhis.services.ILoginService;

public class UhisAuthenticationProvider implements AuthenticationProvider
{

    @Autowired
    private ILoginService loginService;

    public UhisAuthenticationProvider()
    {
        super();
    }

    @Override
    public Authentication authenticate(Authentication authentication)
    {
        String username;
        String password;
        List<GrantedAuthority> userAuthorities;

        username = authentication.getName();
        password = authentication.getCredentials().toString();
        userAuthorities = new ArrayList<>();

        prv_checkCredentials(username, password, userAuthorities);

        return new UsernamePasswordAuthenticationToken(username, password, userAuthorities);

    }

    private void prv_checkCredentials(String username, String password, List<GrantedAuthority> userAuthorities)
    {
        IAuthUser user;

        user = loginService.login(username, password);

        if (user == null)
        {
            throw new BadCredentialsException("user is not find with that credentials");

        }
        else
        {
            userAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
        }

    }

    @Override
    public boolean supports(Class<?> authentication)
    {

        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
