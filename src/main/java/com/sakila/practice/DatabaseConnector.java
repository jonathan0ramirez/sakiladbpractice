package com.sakila.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DatabaseConnector {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(DatabaseConnector.class, args);
    logDatabaseDetails(context.getEnvironment());
}

private static void logDatabaseDetails(Environment environment) {
    String databaseUrl = environment.getProperty("spring.datasource.url");
    String databaseUsername = environment.getProperty("spring.datasource.username");
    String activeProfile = environment.getProperty("spring.profiles.active");

    System.out.println("============================================");
    System.out.println("Database Connection Details");
    System.out.println("============================================");
    System.out.println("Active Profile: " + activeProfile);
    System.out.println("Database URL: " + databaseUrl);
    System.out.println("Database Username: " + databaseUsername);
    // You can add more properties as needed (e.g., driver class, dialect, etc.)
    System.out.println("============================================");
}
}
