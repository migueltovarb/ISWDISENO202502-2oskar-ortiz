package com.ejemplo.vehiculos.controller;

import com.ejemplo.vehiculos.model.Vehiculo;
import com.ejemplo.vehiculos.service.VehiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "*") // Permitir CORS para desarrollo
public class VehiculoController {
    
    @Autowired
    private VehiculoService vehiculoService;
    
    // CREATE - Crear un nuevo vehículo
    @PostMapping
    public ResponseEntity<Vehiculo> crearVehiculo(@Valid @RequestBody Vehiculo vehiculo) {
        Vehiculo nuevoVehiculo = vehiculoService.crearVehiculo(vehiculo);
        return new ResponseEntity<>(nuevoVehiculo, HttpStatus.CREATED);
    }
    
    // READ - Obtener todos los vehículos
    @GetMapping
    public ResponseEntity<List<Vehiculo>> obtenerTodosLosVehiculos() {
        List<Vehiculo> vehiculos = vehiculoService.obtenerTodosLosVehiculos();
        return ResponseEntity.ok(vehiculos);
    }
    
    // READ - Obtener vehículo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> obtenerVehiculoPorId(@PathVariable String id) {
        Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(id);
        return ResponseEntity.ok(vehiculo);
    }
    
    // READ - Obtener vehículo por placa
    @GetMapping("/placa/{placa}")
    public ResponseEntity<Vehiculo> obtenerVehiculoPorPlaca(@PathVariable String placa) {
        Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorPlaca(placa);
        return ResponseEntity.ok(vehiculo);
    }
    
    // UPDATE - Actualizar vehículo
    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizarVehiculo(
            @PathVariable String id, 
            @Valid @RequestBody Vehiculo vehiculo) {
        Vehiculo vehiculoActualizado = vehiculoService.actualizarVehiculo(id, vehiculo);
        return ResponseEntity.ok(vehiculoActualizado);
    }
    
    // DELETE - Eliminar vehículo
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminarVehiculo(@PathVariable String id) {
        vehiculoService.eliminarVehiculo(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Vehículo eliminado exitosamente");
        response.put("id", id);
        return ResponseEntity.ok(response);
    }
    
    // BÚSQUEDAS ADICIONALES
    
    // Buscar por marca
    @GetMapping("/buscar/marca/{marca}")
    public ResponseEntity<List<Vehiculo>> buscarPorMarca(@PathVariable String marca) {
        List<Vehiculo> vehiculos = vehiculoService.buscarPorMarca(marca);
        return ResponseEntity.ok(vehiculos);
    }
    
    // Buscar por marca y modelo
    @GetMapping("/buscar/marca/{marca}/modelo/{modelo}")
    public ResponseEntity<List<Vehiculo>> buscarPorMarcaYModelo(
            @PathVariable String marca, 
            @PathVariable String modelo) {
        List<Vehiculo> vehiculos = vehiculoService.buscarPorMarcaYModelo(marca, modelo);
        return ResponseEntity.ok(vehiculos);
    }
    
    // Buscar por rango de año
    @GetMapping("/buscar/anio")
    public ResponseEntity<List<Vehiculo>> buscarPorRangoAnio(
            @RequestParam Integer inicio, 
            @RequestParam Integer fin) {
        List<Vehiculo> vehiculos = vehiculoService.buscarPorRangoAnio(inicio, fin);
        return ResponseEntity.ok(vehiculos);
    }
    
    // Buscar por rango de precio
    @GetMapping("/buscar/precio")
    public ResponseEntity<List<Vehiculo>> buscarPorRangoPrecio(
            @RequestParam Double min, 
            @RequestParam Double max) {
        List<Vehiculo> vehiculos = vehiculoService.buscarPorRangoPrecio(min, max);
        return ResponseEntity.ok(vehiculos);
    }
    
    // Buscar por tipo de combustible
    @GetMapping("/buscar/combustible/{tipo}")
    public ResponseEntity<List<Vehiculo>> buscarPorTipoCombustible(@PathVariable String tipo) {
        List<Vehiculo> vehiculos = vehiculoService.buscarPorTipoCombustible(tipo);
        return ResponseEntity.ok(vehiculos);
    }
    
    // Buscar por estado
    @GetMapping("/buscar/estado/{estado}")
    public ResponseEntity<List<Vehiculo>> buscarPorEstado(@PathVariable String estado) {
        List<Vehiculo> vehiculos = vehiculoService.buscarPorEstado(estado);
        return ResponseEntity.ok(vehiculos);
    }
}