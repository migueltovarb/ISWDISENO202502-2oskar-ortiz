package com.medicitas.controller;

import com.medicitas.model.Medico;
import com.medicitas.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "*")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    // ✅ Obtener todos los médicos
    @GetMapping
    public ResponseEntity<List<Medico>> listarTodos() {
        return ResponseEntity.ok(medicoService.listarTodos());
    }

    // ✅ Obtener médico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Medico> obtenerPorId(@PathVariable String id) {
        Optional<Medico> medico = medicoService.obtenerPorId(id);
        return medico.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Crear médico
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Medico> crear(@RequestBody Medico medico) {
        Medico nuevo = medicoService.guardar(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // ✅ Actualizar médico (URL estándar REST: /api/medicos/{id})
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> actualizar(@PathVariable String id, @RequestBody Medico medicoActualizado) {
        Optional<Medico> medicoExistente = medicoService.obtenerPorId(id);

        if (medicoExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("❌ Médico con ID " + id + " no encontrado.");
        }

        Medico medicoGuardado = medicoService.actualizar(id, medicoActualizado);
        return ResponseEntity.ok(medicoGuardado);
    }

    // ✅ Eliminar médico
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id) {
        Optional<Medico> medico = medicoService.obtenerPorId(id);
        if (medico.isPresent()) {
            medicoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("❌ Médico con ID " + id + " no encontrado.");
        }
    }
}
