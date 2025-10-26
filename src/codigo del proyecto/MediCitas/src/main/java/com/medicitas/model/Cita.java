package com.medicitas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "citas")
public class Cita {

    @Id
    private String id;
    private String fecha;
    private String hora;
    private String motivo;
    private String idPaciente;
    private String idMedico;
    private EstadoCita estado; // <-- enum

    public Cita() {}

    public Cita(String fecha, String hora, String motivo, String idPaciente, String idMedico, EstadoCita estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.estado = estado;
    }

    // getters / setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getIdPaciente() { return idPaciente; }
    public void setIdPaciente(String idPaciente) { this.idPaciente = idPaciente; }

    public String getIdMedico() { return idMedico; }
    public void setIdMedico(String idMedico) { this.idMedico = idMedico; }

    public EstadoCita getEstado() { return estado; }
    public void setEstado(EstadoCita estado) { this.estado = estado; }
}
