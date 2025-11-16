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

    public List<Cita> listarTodas() {
        return citaRepository.findAll();
    }

    public Optional<Cita> obtenerPorId(String id) {
        return citaRepository.findById(id);
    }

    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita actualizar(String id, Cita citaActualizada) {
        Optional<Cita> optionalCita = citaRepository.findById(id);

        if (optionalCita.isPresent()) {
            Cita citaExistente = optionalCita.get();

            citaExistente.setFecha(citaActualizada.getFecha());
            citaExistente.setHora(citaActualizada.getHora());
            citaExistente.setMotivo(citaActualizada.getMotivo());
            citaExistente.setEstado(citaActualizada.getEstado());
            citaExistente.setIdMedico(citaActualizada.getIdMedico());
            citaExistente.setIdPaciente(citaActualizada.getIdPaciente());

            return citaRepository.save(citaExistente);
        } else {
            return null;
        }
    }

    public void eliminar(String id) {
        citaRepository.deleteById(id);
    }
}
