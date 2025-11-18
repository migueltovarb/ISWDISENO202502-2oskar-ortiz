package com.medicitas.controller;

import com.medicitas.model.HistorialMedico;
import com.medicitas.service.HistorialMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historiales")
@CrossOrigin(origins = "*")
public class HistorialMedicoController {

    @Autowired
    private HistorialMedicoService historialService;

    @GetMapping
    public List<HistorialMedico> listarTodos() {
        return historialService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialMedico> obtenerPorId(@PathVariable String id) {
        Optional<HistorialMedico> historial = historialService.obtenerPorId(id);
        return historial.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistorialMedico> crear(@RequestBody HistorialMedico historial) {
        return ResponseEntity.ok(historialService.guardar(historial));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialMedico> actualizar(@PathVariable String id, @RequestBody HistorialMedico historial) {
        HistorialMedico actualizado = historialService.actualizar(id, historial);
        return actualizado != null ? ResponseEntity.ok(actualizado)
                                   : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        historialService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
