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
    private PacienteRepository pacienteRepository;

    public Paciente crear(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPorId(String id) {
        return pacienteRepository.findById(id);
    }

    public void eliminar(String id) {
        pacienteRepository.deleteById(id);
    }

    public Paciente actualizar(String id, Paciente pacienteActualizado) {
        return pacienteRepository.findById(id).map(paciente -> {
            paciente.setNombre(pacienteActualizado.getNombre());
            paciente.setEdad(pacienteActualizado.getEdad());
            paciente.setCorreo(pacienteActualizado.getCorreo());
            paciente.setTelefono(pacienteActualizado.getTelefono());
            paciente.setHistorialMedico(pacienteActualizado.getHistorialMedico());
            return pacienteRepository.save(paciente);
        }).orElse(null);
    }
}