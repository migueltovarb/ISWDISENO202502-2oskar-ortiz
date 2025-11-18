package com.medicitas.repository;

import com.medicitas.model.HistorialMedico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository  // ✅ AGREGADO
public interface HistorialMedicoRepository extends MongoRepository<HistorialMedico, String> {
}