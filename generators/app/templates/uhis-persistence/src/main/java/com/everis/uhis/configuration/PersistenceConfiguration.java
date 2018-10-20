package com.everis.<%= appName %>.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = { "com.everis.<%= appName %>.entities" })
@EnableJpaRepositories(basePackages = { "com.everis.<%= appName %>.repositories" })
public class PersistenceConfiguration {

}
