package com.challenge.webchat.main.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.challenge.webchat.business.config", "com.challenge.webchat.controller.config",
        "com.challenge.webchat.security.config"})
public class MainConfig {
}
