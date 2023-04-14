package com.gexcode.webservices.restfulwebservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // All requests are authenticated
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        // Ask for authentication if not
        http.httpBasic(Customizer.withDefaults());

        // disable CSRF
        http.csrf().disable();

        return http.build();
    }
}
