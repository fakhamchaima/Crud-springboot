package com.crud.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Spécifie le mapping pour lequel CORS sera configuré
                .allowedOrigins("http://localhost:4200") // Autorise les requêtes provenant de ce domaine
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Autorise ces méthodes HTTP
                .allowedHeaders("*") // Autorise tous les en-têtes
                .allowCredentials(true) // Autorise les informations d'identification
                .maxAge(360000); // Cache la réponse pendant 3600 secondes (1 heure)
    }
}
