package com.medicitas.controller;

import com.medicitas.model.Paciente;
import com.medicitas.repository.PacienteRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    private final PacienteRepository repo;
    public PacienteController(PacienteRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Paciente> all() { return repo.findAll(); }

    @PostMapping
    public Paciente create(@RequestBody Paciente p) { return repo.save(p); }
}
