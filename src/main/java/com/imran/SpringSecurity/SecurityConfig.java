package com.imran.SpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disabling CSRF for simplicity
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated() // All requests need to be authenticated
            )
            .formLogin() // Enable default login form
            .and()
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // Use default session policy
            );

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService(){
         return new InMemoryUserDetailsManager();                                                     
    }
}
