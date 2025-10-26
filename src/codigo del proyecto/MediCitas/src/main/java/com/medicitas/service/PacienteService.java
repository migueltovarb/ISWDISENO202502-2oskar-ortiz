package com.medicitas.service;

import com.medicitas.model.Paciente;
import com.medicitas.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository repo;

    public PacienteService(PacienteRepository repo) {
        this.repo = repo;
    }

    public Paciente crear(Paciente p) {
        return repo.save(p);
    }

    public List<Paciente> listar() {
        return repo.findAll();
    }

    public Optional<Paciente> buscarPorId(String id) {
        return repo.findById(id);
    }

    public void eliminar(String id) {
        repo.deleteById(id);
    }
}
