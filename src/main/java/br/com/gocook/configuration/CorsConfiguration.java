package br.com.gocook.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class CorsConfiguration implements WebMvcConfigurer{


                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**") // Permite todas as rotas
                            .allowedOrigins("*") // Permite o front-end
                            .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                            .allowedHeaders("*") // Permite todos os cabeçalhos
                            .allowCredentials(true); // Permite cookies, se necessário
                }
}
