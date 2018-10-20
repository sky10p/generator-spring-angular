package com.everis.uhis.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public final class JwtAuthenticationData
{

    private static final String PRV_ISSUER = "uhis";
    private static final String PRV_AUTHORITIES_CLAIM = "authorities";
    private static final String PRV_JWT_SECRET_KEY = "Jafas4d54as5gd4a6s5d465a4fr6ea4g56456a4h441ds20fasd.fhashdfhaehfajhejkfhajkhefjkhasljkfdhasfhdasdf";

    private JwtAuthenticationData()
    {
        super();
    }

    public static String getFromAuthentication(Authentication authResult)
    {
        String token;
        String authoritiesString;
        String name;

        authoritiesString = prv_getAuthoritiesFromAuthentication(authResult);

        name = authResult.getName();
        token = prv_createJwt(authoritiesString, name);

        return token;
    }

    public static Authentication getFromToken(String token)
    {

        Authentication authentication;
        String jwt;
        String user;
        List<GrantedAuthority> permissions;

        permissions = new ArrayList<>();

        if (token == null)
        {
            authentication = null;
        }
        else
        {
            Assert.isTrue(token.contains("Bearer "), "Header Authentication Not contains Bearer");
            jwt = token.replace("Bearer ", "");

            user = JWT.decode(jwt).getSubject();

            if (user == null)
            {
                authentication = null;
            }
            else
            {
                authentication = new UsernamePasswordAuthenticationToken(user, null, permissions);
            }

        }

        return authentication;

    }

    private static String prv_createJwt(String authoritiesString, String name)
    {
        Date now;

        now = new Date();

        return JWT.create().withIssuer(PRV_ISSUER).withSubject(name).withIssuedAt(now).withClaim(PRV_AUTHORITIES_CLAIM, authoritiesString).sign(Algorithm.HMAC512(PRV_JWT_SECRET_KEY));
    }

    private static String prv_getAuthoritiesFromAuthentication(Authentication authResult)
    {
        return authResult.getAuthorities().stream().map(Object::toString).collect(Collectors.joining(","));
    }

}
