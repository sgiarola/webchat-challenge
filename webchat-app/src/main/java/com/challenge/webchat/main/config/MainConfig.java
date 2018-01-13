package com.challenge.webchat.main.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.challenge.business.config", "com.challenge.repository.config"})
public class MainConfig {
}
