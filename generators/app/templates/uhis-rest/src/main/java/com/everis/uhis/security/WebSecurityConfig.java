package com.everis.uhis.security;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

    private static final String PRV_LOGIN_URL = "/api/v1/login";

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        LoginFilter loginFilter;
        JwtFilter jwtFilter;

        loginFilter = new LoginFilter(PRV_LOGIN_URL, authenticationManager());

        jwtFilter = new JwtFilter();
		prv_configureHttp(http, loginFilter, jwtFilter);

    }

    private static void prv_configureHttp(HttpSecurity http, LoginFilter loginFilter, JwtFilter jwtFilter) throws Exception
    {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .cors().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, PRV_LOGIN_URL).permitAll()
                .anyRequest().authenticated().and()
                .addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        		
    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider()
    {
        return new UhisAuthenticationProvider();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {

        AuthenticationProvider authenticationProvider;

        authenticationProvider = getAuthenticationProvider();

        auth.authenticationProvider(authenticationProvider);
    }

}
