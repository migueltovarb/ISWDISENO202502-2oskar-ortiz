package com.medicitas.service;

import com.medicitas.model.Medico;
import com.medicitas.repository.MedicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository repo;

    public MedicoService(MedicoRepository repo) {
        this.repo = repo;
    }

    // ✅ Cambiamos el nombre a "save" para coincidir con el controlador
    public Medico save(Medico medico) {
        return repo.save(medico);
    }

    public List<Medico> findAll() {
        return repo.findAll();
    }

    public Medico findById(String id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}
