package com.ejemplo.vehiculos.repository;

import com.ejemplo.vehiculos.model.Vehiculo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculoRepository extends MongoRepository<Vehiculo, String> {
    
    // Métodos de consulta personalizados
    
    // Buscar por placa
    Optional<Vehiculo> findByPlaca(String placa);
    
    // Buscar por marca
    List<Vehiculo> findByMarca(String marca);
    
    // Buscar por marca y modelo
    List<Vehiculo> findByMarcaAndModelo(String marca, String modelo);
    
    // Buscar por rango de año
    List<Vehiculo> findByAnioBetween(Integer anioInicio, Integer anioFin);
    
    // Buscar por rango de precio
    List<Vehiculo> findByPrecioBetween(Double precioMin, Double precioMax);
    
    // Buscar por tipo de combustible
    List<Vehiculo> findByTipoCombustible(String tipoCombustible);
    
    // Buscar por estado
    List<Vehiculo> findByEstado(String estado);
    
    // Verificar si existe una placa
    boolean existsByPlaca(String placa);
}