package com.medicitas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class Usuario {
    @Id
    private String id;
    private String nombre;
    private String correo;
    private String passwordHash;
    private String rol; // "PACIENTE", "MEDICO", "ADMIN"
}

