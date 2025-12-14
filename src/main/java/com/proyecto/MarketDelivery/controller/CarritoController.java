package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Carrito;
import com.proyecto.MarketDelivery.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carritos")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public List<Carrito> getAllCarritos() {
        return carritoService.getAllCarritos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> getCarritoById(@PathVariable Integer id) {
        return carritoService.getCarritoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Carrito createCarrito(@RequestBody Carrito carrito) {
        return carritoService.saveCarrito(carrito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> updateCarrito(@PathVariable Integer id, @RequestBody Carrito carrito) {
        return carritoService.getCarritoById(id)
                .map(existing -> {
                    carrito.setId(id);
                    return ResponseEntity.ok(carritoService.saveCarrito(carrito));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrito(@PathVariable Integer id) {
        carritoService.deleteCarrito(id);
        return ResponseEntity.noContent().build();
    }
}
