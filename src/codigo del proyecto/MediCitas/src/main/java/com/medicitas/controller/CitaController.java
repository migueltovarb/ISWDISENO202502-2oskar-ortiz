package com.medicitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.medicitas.model.Cita;
import com.medicitas.repository.CitaRepository;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    // ✅ 1. Obtener todas las citas
    @GetMapping
    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    // ✅ 2. Crear una nueva cita (POST)
    @PostMapping
    public Cita crearCita(@RequestBody Cita cita) {
        return citaRepository.save(cita);
    }
}
