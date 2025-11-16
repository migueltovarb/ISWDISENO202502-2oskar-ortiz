package com.medicitas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "citas")
public class Cita {

    @Id
    private String id;
    private String fecha;      // Ejemplo: "2025-11-10"
    private String hora;       // Ejemplo: "09:30"
    private String motivo;     // Ejemplo: "Consulta general"
    private String estado;     // Ejemplo: "Agendada", "Cancelada", "Completada"
    private String idMedico;   // ID del médico
    private String idPaciente; // ID del paciente

    public Cita() {}

    public Cita(String fecha, String hora, String motivo, String estado, String idMedico, String idPaciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getIdMedico() { return idMedico; }
    public void setIdMedico(String idMedico) { this.idMedico = idMedico; }

    public String getIdPaciente() { return idPaciente; }
    public void setIdPaciente(String idPaciente) { this.idPaciente = idPaciente; }
}
