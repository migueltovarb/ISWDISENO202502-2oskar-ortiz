package com.medicitas.repository;

import com.medicitas.model.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, String> {
    Medico findByEspecialidad(String especialidad);
}
