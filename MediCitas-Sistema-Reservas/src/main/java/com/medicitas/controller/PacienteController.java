package com.medicitas.controller;

import com.medicitas.model.Paciente;
import com.medicitas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "http://localhost:5173") // Cambia según el puerto de tu frontend
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // 🟢 1. Obtener todos los pacientes
    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        return ResponseEntity.ok(pacienteService.listar());
    }

    // 🟢 2. Obtener un paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable String id) {
        return pacienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🟢 3. Crear un nuevo paciente
    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        Paciente nuevoPaciente = pacienteService.crear(paciente);
        return ResponseEntity.ok(nuevoPaciente);
    }

    // 🟡 4. Actualizar un paciente existente
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

    // 🔴 5. Eliminar un paciente por ID
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
