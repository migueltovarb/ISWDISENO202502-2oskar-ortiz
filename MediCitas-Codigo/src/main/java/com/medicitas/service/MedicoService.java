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

    public Medico actualizar(String id, Medico medicoActualizado) {
        Optional<Medico> optionalMedico = medicoRepository.findById(id);

        if (optionalMedico.isPresent()) {
            Medico medicoExistente = optionalMedico.get();

            // Ajustar campos según tu clase Medico
            medicoExistente.setNombre(medicoActualizado.getNombre());
            medicoExistente.setEspecialidad(medicoActualizado.getEspecialidad());
            medicoExistente.setTelefono(medicoActualizado.getTelefono());
            medicoExistente.setEmail(medicoActualizado.getEmail()); // ✅ aquí era "email", no "correo"

            return medicoRepository.save(medicoExistente);
        } else {
            return null; // puedes lanzar una excepción si prefieres manejarlo de otra forma
        }
    }

    public void eliminar(String id) {
        medicoRepository.deleteById(id);
    }
}
