package com.medicitas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.medicitas.model.Cita;

public interface CitaRepository extends MongoRepository<Cita, String> {

}
