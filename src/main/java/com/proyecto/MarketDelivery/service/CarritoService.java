package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Carrito;
import com.proyecto.MarketDelivery.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public List<Carrito> getAllCarritos() {
        return carritoRepository.findAll();
    }

    public Optional<Carrito> getCarritoById(Integer id) {
        return carritoRepository.findById(id);
    }

    public Carrito saveCarrito(Carrito c) {
        return carritoRepository.save(c);
    }

    public void deleteCarrito(Integer id) {
        carritoRepository.deleteById(id);
    }
}
