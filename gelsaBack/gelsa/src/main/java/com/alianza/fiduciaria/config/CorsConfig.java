package com.alianza.fiduciaria.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Permitir requisições de qualquer origem
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permitir os métodos HTTP especificados
                .allowedHeaders("*"); // Permitir todos os headers
    }
}
