package com.challenge.webchat.security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.challenge.webchat.security.service", "com.challenge.webchat.security.handler"})
public class SecurityConfig {
}
