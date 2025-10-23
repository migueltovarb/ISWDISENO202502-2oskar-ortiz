package com.medicitas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "citas")
public class Cita {

    @Id
    private String id;

    private String pacienteId;
    private String medicoId;
    private LocalDateTime fecha;
    private EstadoCita estado;
}
