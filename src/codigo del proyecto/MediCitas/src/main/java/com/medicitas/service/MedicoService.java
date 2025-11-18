package com.medicitas.service;

import com.medicitas.model.Medico;
import com.medicitas.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> obtenerPorId(String id) {
        return medicoRepository.findById(id);
    }

    public Medico guardar(Medico medico) {
        return medicoRepository.save(medico);
    }

    /**
     * Actualiza los campos del médico (nombre, especialidad, telefono, email)
     * Asegúrate que tu modelo Medico tenga getters/setters para email si lo usas.
     */
    public Medico actualizar(String id, Medico datosActualizados) {
        Optional<Medico> optional = medicoRepository.findById(id);
        if (optional.isPresent()) {
            Medico existente = optional.get();

            if (datosActualizados.getNombre() != null) {
                existente.setNombre(datosActualizados.getNombre());
            }
            if (datosActualizados.getEspecialidad() != null) {
                existente.setEspecialidad(datosActualizados.getEspecialidad());
            }
            if (datosActualizados.getTelefono() != null) {
                existente.setTelefono(datosActualizados.getTelefono());
            }
            // email puede ser opcional
            try {
                if (datosActualizados.getEmail() != null) {
                    existente.setEmail(datosActualizados.getEmail());
                }
            } catch (Exception ignored) {
                // Si tu clase Medico no tiene email, esto no rompe (pero revisa el modelo)
            }

            return medicoRepository.save(existente);
        } else {
            return null;
        }
    }

    public void eliminar(String id) {
        medicoRepository.deleteById(id);
    }
}
