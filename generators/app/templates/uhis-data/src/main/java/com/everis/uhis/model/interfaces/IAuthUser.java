package com.everis.uhis.model.interfaces;

import com.everis.uhis.model.AuthUserDto;
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
