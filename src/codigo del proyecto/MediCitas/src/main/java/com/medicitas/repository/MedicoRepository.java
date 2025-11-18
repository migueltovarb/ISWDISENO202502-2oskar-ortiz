package com.medicitas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.medicitas.model.Medico;

@Repository  // ✅ AGREGADO
public interface MedicoRepository extends MongoRepository<Medico, String> {
}
