package com.SalaLivre.reservas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) 
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/**").permitAll()
                .anyRequest().authenticated()                  
            )
            
            // O H2 Console é renderizado dentro de um <iframe>. 
            // O Spring Security bloqueia iframes por padrão para evitar ataques de Clickjacking.
            .headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }
}