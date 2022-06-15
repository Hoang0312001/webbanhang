package com.example.storefurniture.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class corsconfig {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*")
                        .maxAge(31536000)
                        .allowCredentials(false)
                        .allowedOrigins("*")
                        .allowedHeaders("Content-Type","X-AUTH-TOKEN","Cache-Control","Origin","Authorization");
            }
        };
    }
}
