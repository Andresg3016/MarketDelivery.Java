package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Producto;
import com.proyecto.MarketDelivery.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    public Producto saveProducto(Producto p) {
        return productoRepository.save(p);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
