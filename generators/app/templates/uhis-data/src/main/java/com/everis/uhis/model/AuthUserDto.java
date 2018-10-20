package com.everis.<%= appName %>.model;

import com.everis.<%= appName %>.model.interfaces.IAuthUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class AuthUserDto implements IAuthUser
{

    private @NonNull String username;

    @NonNull
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    @NonNull
    @JsonProperty(access = Access.WRITE_ONLY)
    private String salt;

    public AuthUserDto(IAuthUser authUser)
    {
        username = authUser.getUsername();
        password = authUser.getPassword();
        salt = authUser.getSalt();
    }

}
