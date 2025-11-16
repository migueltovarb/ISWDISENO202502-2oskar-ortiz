package com.medicitas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.medicitas.model.Medico;

public interface MedicoRepository extends MongoRepository<Medico, String> {
}
