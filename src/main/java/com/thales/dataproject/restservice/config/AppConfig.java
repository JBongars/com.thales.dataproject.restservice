package com.thales.dataproject.restservice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public abstract class AppConfig {
    public final static String API_KEY = System.getenv("API_KEY");
}
