package com.everis.<%= appName %>.services;

import com.everis.<%= appName %>.model.interfaces.IAuthUser;

public interface ILoginService
{

    IAuthUser login(String username, String password);

    IAuthUser findMe(String username);

}
