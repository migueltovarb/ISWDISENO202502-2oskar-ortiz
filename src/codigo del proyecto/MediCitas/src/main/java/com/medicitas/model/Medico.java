package com.medicitas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "medicos")
public class Medico {
    @Id
    private String idMedico;
    private String nombre;
    private String especialidad;
    private String telefono;
    private String correo;
}
