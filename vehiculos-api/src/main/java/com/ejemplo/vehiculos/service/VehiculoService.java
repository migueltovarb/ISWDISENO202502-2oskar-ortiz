package com.ejemplo.vehiculos.service;

import com.ejemplo.vehiculos.exception.DuplicateResourceException;
import com.ejemplo.vehiculos.exception.ResourceNotFoundException;
import com.ejemplo.vehiculos.model.Vehiculo;
import com.ejemplo.vehiculos.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehiculoService {
    
    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    // Crear un nuevo vehículo
    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
        // Verificar si la placa ya existe
        if (vehiculoRepository.existsByPlaca(vehiculo.getPlaca())) {
            throw new DuplicateResourceException("Vehículo", "placa", vehiculo.getPlaca());
        }
        vehiculo.setFechaRegistro(LocalDateTime.now());
        return vehiculoRepository.save(vehiculo);
    }
    
    // Obtener todos los vehículos
    public List<Vehiculo> obtenerTodosLosVehiculos() {
        return vehiculoRepository.findAll();
    }
    
    // Obtener vehículo por ID
    public Vehiculo obtenerVehiculoPorId(String id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo", "id", id));
    }
    
    // Obtener vehículo por placa
    public Vehiculo obtenerVehiculoPorPlaca(String placa) {
        return vehiculoRepository.findByPlaca(placa)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo", "placa", placa));
    }
    
    // Actualizar vehículo
    public Vehiculo actualizarVehiculo(String id, Vehiculo vehiculoActualizado) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo", "id", id));
        
        // Verificar si la nueva placa ya existe en otro vehículo
        if (!vehiculo.getPlaca().equals(vehiculoActualizado.getPlaca()) 
            && vehiculoRepository.existsByPlaca(vehiculoActualizado.getPlaca())) {
            throw new DuplicateResourceException("Vehículo", "placa", vehiculoActualizado.getPlaca());
        }
        
        vehiculo.setMarca(vehiculoActualizado.getMarca());
        vehiculo.setModelo(vehiculoActualizado.getModelo());
        vehiculo.setAnio(vehiculoActualizado.getAnio());
        vehiculo.setColor(vehiculoActualizado.getColor());
        vehiculo.setPlaca(vehiculoActualizado.getPlaca());
        vehiculo.setPrecio(vehiculoActualizado.getPrecio());
        vehiculo.setTipoCombustible(vehiculoActualizado.getTipoCombustible());
        vehiculo.setTransmision(vehiculoActualizado.getTransmision());
        vehiculo.setKilometraje(vehiculoActualizado.getKilometraje());
        vehiculo.setEstado(vehiculoActualizado.getEstado());
        vehiculo.setDescripcion(vehiculoActualizado.getDescripcion());
        
        return vehiculoRepository.save(vehiculo);
    }
    
    // Eliminar vehículo
    public void eliminarVehiculo(String id) {
        if (!vehiculoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vehículo", "id", id);
        }
        vehiculoRepository.deleteById(id);
    }
    
    // Métodos de búsqueda adicionales
    
    public List<Vehiculo> buscarPorMarca(String marca) {
        return vehiculoRepository.findByMarca(marca);
    }
    
    public List<Vehiculo> buscarPorMarcaYModelo(String marca, String modelo) {
        return vehiculoRepository.findByMarcaAndModelo(marca, modelo);
    }
    
    public List<Vehiculo> buscarPorRangoAnio(Integer anioInicio, Integer anioFin) {
        return vehiculoRepository.findByAnioBetween(anioInicio, anioFin);
    }
    
    public List<Vehiculo> buscarPorRangoPrecio(Double precioMin, Double precioMax) {
        return vehiculoRepository.findByPrecioBetween(precioMin, precioMax);
    }
    
    public List<Vehiculo> buscarPorTipoCombustible(String tipoCombustible) {
        return vehiculoRepository.findByTipoCombustible(tipoCombustible);
    }
    
    public List<Vehiculo> buscarPorEstado(String estado) {
        return vehiculoRepository.findByEstado(estado);
    }
}