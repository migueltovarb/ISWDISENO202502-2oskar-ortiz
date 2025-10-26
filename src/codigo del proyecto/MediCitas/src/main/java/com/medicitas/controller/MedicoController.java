package com.medicitas.controller;

import com.medicitas.model.Medico;
import com.medicitas.service.MedicoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @PostMapping
    public Medico create(@RequestBody Medico medico) {
        return service.save(medico); // ✅ ya coincide con el método del service
    }

    @GetMapping
    public List<Medico> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Medico getById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
