package org.exam.locationbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Désactiver CSRF pour permettre les requêtes POST/PUT/DELETE depuis Swagger ou Angular
        http.csrf(csrf -> csrf.disable());
        
        // Permettre l'affichage des frames (utile si vous utilisez h2-console)
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));
        
        // Autoriser TOUTES les requêtes publiquement pour pouvoir tester Swagger
        // (Nous pourrons restreindre cela plus tard lors de l'implémentation de JWT)
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        
        return http.build();
    }
}
