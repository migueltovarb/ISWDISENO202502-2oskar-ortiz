package com.medicitas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "historiales_medicos")
public class HistorialMedico {

    @Id
    private String id;
    private String pacienteId;
    private String antecedentes;
    private String alergias;
    private String medicamentos;
    private String observaciones;

    public HistorialMedico() {}

    public HistorialMedico(String pacienteId, String antecedentes, String alergias, String medicamentos, String observaciones) {
        this.pacienteId = pacienteId;
        this.antecedentes = antecedentes;
        this.alergias = alergias;
        this.medicamentos = medicamentos;
        this.observaciones = observaciones;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPacienteId() { return pacienteId; }
    public void setPacienteId(String pacienteId) { this.pacienteId = pacienteId; }

    public String getAntecedentes() { return antecedentes; }
    public void setAntecedentes(String antecedentes) { this.antecedentes = antecedentes; }

    public String getAlergias() { return alergias; }
    public void setAlergias(String alergias) { this.alergias = alergias; }

    public String getMedicamentos() { return medicamentos; }
    public void setMedicamentos(String medicamentos) { this.medicamentos = medicamentos; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}