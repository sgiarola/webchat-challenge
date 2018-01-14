package com.challenge.webchat.controller.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.challenge.webchat.controller.user", "com.challenge.webchat.controller.login"})
public class ControllerConfig {

}
