package com.deliverytech.delivery.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HealthController { 

 

    @GetMapping("/health") 

    public Map<String, String> health() { 

        return Map.of( 

            "status", "UP", 

            "timestamp", LocalDateTime.now().toString(), 

            "service", "Delivery API", 

            "javaVersion", System.getProperty("java.version") 

        ); 

    } 

 

    @GetMapping("/info") 

    public AppInfo info() { 

        return new AppInfo( 

            "Delivery Tech API", 

            "1.0.0", 

            "Thales", 

            "JDK 21", 

            "Spring Boot 3.2.x" 

        ); 

    } 

 

    // Record para demonstrar recurso do Java 14+ (disponível no JDK 21) 

    public record AppInfo( 

        String application, 

        String version, 

        String developer, 

        String javaVersion, 

        String framework 

    ) {} 

} 

