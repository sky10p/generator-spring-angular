package com.everis.<%= appName %>.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JwtFilter extends GenericFilterBean
{

    private static final String PRV_AUTHORIZATION = "Authorization";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {

        String token;
        Authentication authentication;

        token = prv_getAuthorizationHeader(request);
        authentication = JwtAuthenticationData.getFromToken(token);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);

    }

    private static String prv_getAuthorizationHeader(ServletRequest request)
    {
        return ((HttpServletRequest) request).getHeader(PRV_AUTHORIZATION);
    }

}
