package com.medicitas.controller;

import com.medicitas.model.Paciente;
import com.medicitas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")  // ✅ CORREGIDO - era "http://localhost:5173"
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        return ResponseEntity.ok(pacienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable String id) {
        return pacienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        Paciente nuevoPaciente = pacienteService.crear(paciente);
        return ResponseEntity.ok(nuevoPaciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable String id, @RequestBody Paciente pacienteActualizado) {
        return pacienteService.buscarPorId(id).map(p -> {
            p.setNombre(pacienteActualizado.getNombre());
            p.setEdad(pacienteActualizado.getEdad());
            p.setCorreo(pacienteActualizado.getCorreo());
            p.setTelefono(pacienteActualizado.getTelefono());
            p.setHistorialMedico(pacienteActualizado.getHistorialMedico());
            return ResponseEntity.ok(pacienteService.crear(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable String id) {
        if (pacienteService.buscarPorId(id).isPresent()) {
            pacienteService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}