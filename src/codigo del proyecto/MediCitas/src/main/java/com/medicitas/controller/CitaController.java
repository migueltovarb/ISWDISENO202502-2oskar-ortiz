package com.medicitas.controller;

import com.medicitas.model.Cita;
import com.medicitas.service.CitaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
    private final CitaService service;
    public CitaController(CitaService service) { this.service = service; }

    @GetMapping
    public List<Cita> all() { return service.getAll(); }

    @PostMapping
    public Cita create(@RequestBody Cita c) { return service.create(c); }
}
