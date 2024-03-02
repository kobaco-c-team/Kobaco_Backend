package com.kobaco.kobaco_project.infrastructure.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.kobaco.kobaco_project.infrastructure.storage")
@EnableJpaAuditing
@EntityScan(basePackages = "com.kobaco.kobaco_project.infrastructure.storage")
public class JpaConfig {
}
