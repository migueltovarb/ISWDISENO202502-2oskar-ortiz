package com.medicitas.service;

import com.medicitas.model.Cita;
import com.medicitas.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    // Obtener todas las citas
    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    // Guardar o crear una cita
    public Cita save(Cita cita) {
        return citaRepository.save(cita);
    }

    // Buscar cita por ID
    public Optional<Cita> findById(String id) {
        return citaRepository.findById(id);
    }

    // Eliminar cita por ID
    public void deleteById(String id) {
        citaRepository.deleteById(id);
    }
}
