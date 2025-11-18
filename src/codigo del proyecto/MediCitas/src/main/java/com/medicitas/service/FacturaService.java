package com.medicitas.service;

import com.medicitas.model.Factura;
import com.medicitas.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> listarFacturas() {
        return facturaRepository.findAll();
    }

    public Optional<Factura> obtenerPorId(String id) {
        return facturaRepository.findById(id);
    }

    public Factura crearFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura actualizarFactura(String id, Factura facturaActualizada) {
        return facturaRepository.findById(id).map(factura -> {
            factura.setFechaEmision(facturaActualizada.getFechaEmision());
            factura.setMontoTotal(facturaActualizada.getMontoTotal());
            factura.setMetodoPago(facturaActualizada.getMetodoPago());
            factura.setDescripcion(facturaActualizada.getDescripcion());
            factura.setPacienteId(facturaActualizada.getPacienteId());
            factura.setCitaId(facturaActualizada.getCitaId());
            return facturaRepository.save(factura);
        }).orElse(null);
    }

    public void eliminarFactura(String id) {
        facturaRepository.deleteById(id);
    }
}