package com.medicitas.repository;

import com.medicitas.model.HistorialMedico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistorialMedicoRepository extends MongoRepository<HistorialMedico, String> {
}
