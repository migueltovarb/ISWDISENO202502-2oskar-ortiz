package com.medicitas.service;

import com.medicitas.model.Paciente;
import com.medicitas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repo;

    public Paciente crear(Paciente paciente) {
        return repo.save(paciente);
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
