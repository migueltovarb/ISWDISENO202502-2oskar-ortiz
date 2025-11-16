package com.medicitas.controller;

import com.medicitas.model.Factura;
import com.medicitas.service.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturas")
@CrossOrigin(origins = "*")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> listarFacturas() {
        return facturaService.listarFacturas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerPorId(@PathVariable String id) {
        Optional<Factura> factura = facturaService.obtenerPorId(id);
        return factura.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {
        Factura nuevaFactura = facturaService.crearFactura(factura);
        return ResponseEntity.ok(nuevaFactura);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Factura> actualizarFactura(@PathVariable String id, @RequestBody Factura facturaActualizada) {
        Factura factura = facturaService.actualizarFactura(id, facturaActualizada);
        if (factura != null) {
            return ResponseEntity.ok(factura);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable String id) {
        facturaService.eliminarFactura(id);
        return ResponseEntity.noContent().build();
    }
}
