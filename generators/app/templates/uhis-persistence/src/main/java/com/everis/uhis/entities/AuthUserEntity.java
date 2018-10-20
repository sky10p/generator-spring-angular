package com.everis.<%= appName %>.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.everis.<%= appName %>.model.interfaces.IAuthUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "<%= APPNAME_UPPERCASE %>_AUTH_USER")
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthUserEntity implements IAuthUser
{

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private @NonNull String username;

    @Column(name = "password", nullable = false, unique = false)
    private @NonNull String password;

    @Column(name = "salt", nullable = false, unique = false)
    private @NonNull String salt;

    public AuthUserEntity(IAuthUser authUser)
    {
        this(authUser.getUsername(), authUser.getPassword(), authUser.getSalt());
    }

}
