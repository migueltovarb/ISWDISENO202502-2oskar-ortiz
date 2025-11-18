package com.medicitas.service;

import com.medicitas.model.HistorialMedico;
import com.medicitas.repository.HistorialMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialMedicoService {

    @Autowired
    private HistorialMedicoRepository historialRepository;

    public List<HistorialMedico> listarTodos() {
        return historialRepository.findAll();
    }

    public Optional<HistorialMedico> obtenerPorId(String id) {
        return historialRepository.findById(id);
    }

    public HistorialMedico guardar(HistorialMedico historial) {
        return historialRepository.save(historial);
    }

    public HistorialMedico actualizar(String id, HistorialMedico actualizado) {
        return historialRepository.findById(id)
                .map(historial -> {
                    historial.setPacienteId(actualizado.getPacienteId());
                    historial.setAntecedentes(actualizado.getAntecedentes());  // ✅ CORREGIDO
                    historial.setAlergias(actualizado.getAlergias());          // ✅ CORREGIDO
                    historial.setMedicamentos(actualizado.getMedicamentos());  // ✅ CORREGIDO
                    historial.setObservaciones(actualizado.getObservaciones());
                    return historialRepository.save(historial);
                })
                .orElse(null);
    }

    public void eliminar(String id) {
        historialRepository.deleteById(id);
    }
}