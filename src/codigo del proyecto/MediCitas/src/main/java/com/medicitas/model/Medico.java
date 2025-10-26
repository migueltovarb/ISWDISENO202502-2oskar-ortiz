package com.medicitas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medicos")
public class Medico {

    @Id
    private String id;
    private String nombre;
    private String especialidad;
    private String correo;
    private String telefono;
    private String horario;

    public Medico() {}

    public Medico(String nombre, String especialidad, String correo, String telefono, String horario) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.correo = correo;
        this.telefono = telefono;
        this.horario = horario;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
}
