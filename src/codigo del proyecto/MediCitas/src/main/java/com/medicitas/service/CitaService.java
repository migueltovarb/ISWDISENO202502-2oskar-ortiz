package com.medicitas.service;

import com.medicitas.model.Cita;
import com.medicitas.repository.CitaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitaService {
    private final CitaRepository repo;

    public CitaService(CitaRepository repo) {
        this.repo = repo;
    }

    public Cita create(Cita c) {
        c.setEstado(com.medicitas.model.EstadoCita.PENDIENTE);
        return repo.save(c);
    }

    public List<Cita> getAll() { return repo.findAll(); }

    // más métodos según necesidad
}
