package com.everis.uhis.services;

import com.everis.uhis.model.interfaces.IAuthUser;

public interface ILoginService
{

    IAuthUser login(String username, String password);

    IAuthUser findMe(String username);

}
