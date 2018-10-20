package com.everis.<%= appName %>.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.everis.<%= appName %>.exceptions.ErrorDetails;
import com.everis.<%= appName %>.model.interfaces.IAuthUser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginFilter extends AbstractAuthenticationProcessingFilter
{

    private static final String PRV_BEARER = "Bearer ";
    private static final String PRV_AUTHORIZATION = "Authorization";

    public LoginFilter(String url, AuthenticationManager authManager)
    {
        super(new AntPathRequestMatcher(url));
        prv_init(authManager);
    }

    private void prv_init(AuthenticationManager authManager)
    {
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException
    {

        InputStream body;
        IAuthUser authUser;
        String username;
        String password;
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;

        body = request.getInputStream();
        authUser = new ObjectMapper().readValue(body, IAuthUser.class);

        username = authUser.getUsername();
        password = authUser.getPassword();
        usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        return getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain next,
            Authentication authResult) throws IOException, ServletException
    {

        String token;
        String tokenBearer;

        token = JwtAuthenticationData.getFromAuthentication(authResult);

        tokenBearer = PRV_BEARER + token;
        response.addHeader(PRV_AUTHORIZATION, tokenBearer);
        response.getOutputStream().print("\"" + tokenBearer + "\"");
    }

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		response.setContentType( MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

         ErrorDetails authenticationError = new ErrorDetails(failed, HttpStatus.UNAUTHORIZED.value());
         ObjectMapper objectMapper = new ObjectMapper();
         response.getWriter().write(objectMapper.writeValueAsString(authenticationError));
	}
    
    

}
