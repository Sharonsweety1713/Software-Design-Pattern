package com._tucs212.VitalEcho.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com._tucs212.VitalEcho.auth.CustomLogoutHandler;
import com._tucs212.VitalEcho.auth.CustomLogoutSuccessHandler;
import com._tucs212.VitalEcho.repo.TokenRepo;

@Configuration
public class LogoutConfiguration {

    @Bean
    public CustomLogoutHandler logoutHandler(TokenRepo tokenRepo, JwtService jwtService) {
        return new CustomLogoutHandler(tokenRepo, jwtService);
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }
}
