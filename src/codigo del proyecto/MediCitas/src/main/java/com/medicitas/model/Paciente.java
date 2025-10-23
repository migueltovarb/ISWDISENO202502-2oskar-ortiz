package com.medicitas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pacientes")
public class Paciente {
    @Id
    private String id;
    private String nombre;
    private String correo;
    private String telefono;
    private String fechaNacimiento;
    // getters/setters generados por Lombok (@Data)
}
