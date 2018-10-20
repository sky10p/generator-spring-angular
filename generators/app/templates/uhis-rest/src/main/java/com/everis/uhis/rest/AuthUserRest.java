package com.everis.uhis.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.uhis.model.interfaces.IAuthUser;
import com.everis.uhis.services.ILoginService;

@RestController
@RequestMapping("api/v1/users")
public class AuthUserRest
{

    @Autowired
    private ILoginService loginService;

    public AuthUserRest()
    {
        super();
    }

    @GetMapping(value = "me")
    public IAuthUser me()
    {
        String name;
        IAuthUser me;

        name = SecurityContextHolder.getContext().getAuthentication().getName();
        Assert.notNull(name, "User should be logged");

        me = loginService.findMe(name);

        return me;
    }
}
