package com.miis.gestion_registros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Indica que esta clase contiene definiciones de beans de configuración
@EnableWebSecurity // Habilita la seguridad web de Spring
public class SecurityConfig {

    @Bean // Define un bean de Spring para la cadena de filtros de seguridad
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilita CSRF si es una API REST sin sesiones
                .authorizeHttpRequests(authorize -> authorize
                        // Permite el acceso a los endpoints de Actuator sin autenticación si lo
                        // necesitas
                        // .requestMatchers("/actuator/**").permitAll()
                        // Protege todos los demás endpoints
                        .anyRequest().authenticated() // Cualquier solicitud requiere autenticación
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt()); // Habilita OAuth2 Resource Server con JWT

        return http.build();
    }
}