package com.medicitas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MediCitasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediCitasApplication.class, args);
        System.out.println("\n========================================");
        System.out.println("✅ MediCitas Application Started!");
        System.out.println("🌐 URL: http://localhost:8080");
        System.out.println("========================================\n");
    }
}