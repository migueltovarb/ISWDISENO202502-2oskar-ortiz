package com.ejemplo.vehiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehiculosApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehiculosApiApplication.class, args);
        System.out.println("====================================");
        System.out.println("API de Vehículos iniciada correctamente");
        System.out.println("Accede a: http://localhost:8080/api/vehiculos");
        System.out.println("====================================");
    }
}