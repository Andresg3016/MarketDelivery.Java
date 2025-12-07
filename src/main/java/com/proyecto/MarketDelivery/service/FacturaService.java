package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Factura;
import com.proyecto.MarketDelivery.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    public Optional<Factura> getFacturaById(Integer id) {
        return facturaRepository.findById(id);
    }

    public Factura saveFactura(Factura f) {
        return facturaRepository.save(f);
    }

    public void deleteFactura(Integer id) {
        facturaRepository.deleteById(id);
    }
}
