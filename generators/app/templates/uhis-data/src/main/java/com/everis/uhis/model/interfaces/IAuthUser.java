package com.everis.<%= appName %>.model.interfaces;

import com.everis.<%= appName %>.model.AuthUserDto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = AuthUserDto.class)
public interface IAuthUser
{

    String getUsername();

    String getPassword();

    String getSalt();

    void setUsername(String username);

    void setPassword(String password);

    void setSalt(String salt);
}
