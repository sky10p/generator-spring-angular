package com.everis.uhis.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = { "com.everis.uhis.entities" })
@EnableJpaRepositories(basePackages = { "com.everis.uhis.repositories" })
public class PersistenceConfiguration {

}
