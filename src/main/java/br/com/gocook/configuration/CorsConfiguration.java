//package br.com.gocook.configuration;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableWebSecurity
//public class CorsConfiguration extends org.springframework.web.cors.CorsConfiguration {
//
////
////    @Override
////    public void addCorsMappings(CorsRegistry registry) {
////        registry.addMapping("/**") // Permite todas as rotas
////                .allowedOrigins("*")
////                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Inclua OPTIONS, que é usado nas preflight requests
////                .allowedHeaders("*") // Permite todos os cabeçalhos
////                .allowCredentials(true); // Permite cookies, se necessário
////    }
//
//    @Bean(name = "corsFilterChain")
//    public SecurityFilterChain corsFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors().and() // Ativa CORS
//                .csrf().disable(); // Desativa CSRF para testes
//
//        return http.build();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*")); // Origens permitidas
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos permitidos
//        configuration.setAllowedHeaders(Arrays.asList("*")); // Cabeçalhos permitidos
//        configuration.setAllowCredentials(true); // Permite cookies/autenticação via credenciais
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration); // Aplica a configuração para todas as rotas
//        return (CorsConfigurationSource) source;
//    }
//}

