package com.challenge.webchat.business.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.challenge.webchat.repository.config", "com.challenge.webchat.business.login"})
public class BusinessConfig {
}
