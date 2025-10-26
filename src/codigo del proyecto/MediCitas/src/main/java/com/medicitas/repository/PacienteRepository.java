package com.medicitas.repository;

import com.medicitas.model.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String> {
    // Puedes agregar consultas personalizadas si las necesitas
    Paciente findByCorreo(String correo);
}
