package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Factura;
import com.proyecto.MarketDelivery.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> getAllFacturas() {
        return facturaService.getAllFacturas();
    }

    @GetMapping("/{id}")
    public Factura getFacturaById(@PathVariable Long id) {
        return facturaService.getFacturaById(id);
    }

    @PostMapping
    public Factura createFactura(@RequestBody Factura factura) {
        return facturaService.saveFactura(factura);
    }

    @PutMapping("/{id}")
    public Factura updateFactura(@PathVariable Long id, @RequestBody Factura factura) {
        Factura existing = facturaService.getFacturaById(id);
        if (existing != null) {
            factura.setId(id);
            return facturaService.saveFactura(factura);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFactura(@PathVariable Long id) {
        facturaService.deleteFactura(id);
        return ResponseEntity.noContent().build();
    }
}
