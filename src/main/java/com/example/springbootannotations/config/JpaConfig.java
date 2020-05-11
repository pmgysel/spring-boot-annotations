package com.example.springbootannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.springbootannotations.persistence")
@EnableTransactionManagement
public class JpaConfig {

  private final AnnotationsAppProperties properties;

  public JpaConfig(AnnotationsAppProperties properties) {
    this.properties = properties;
  }

  @Bean
  public DataSource dataSource() {
    AnnotationsAppProperties.PersistenceProperties persistenceProperties = properties.getPersistence();
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(persistenceProperties.getDriverClassName());
    dataSource.setUrl(persistenceProperties.getUrl());
    dataSource.setUsername(persistenceProperties.getUsername());
    dataSource.setPassword(persistenceProperties.getPassword());

    return dataSource;
  }

}