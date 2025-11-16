package com.medicitas.model;

import lombok.Data;

@Data
public class Horario {
    private String diaSemana; // e.g., "LUNES"
    private String horaInicio; // "08:00"
    private String horaFin;    // "12:00"
}
