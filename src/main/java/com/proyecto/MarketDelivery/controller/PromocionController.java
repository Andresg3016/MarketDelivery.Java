package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Promocion;
import com.proyecto.MarketDelivery.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promociones")
public class PromocionController {

    @Autowired
    private PromocionService promocionService;

    @GetMapping
    public List<Promocion> getAllPromociones() {
        return promocionService.getAllPromociones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promocion> getPromocionById(@PathVariable int id) {
        return promocionService.getPromocionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Promocion createPromocion(@RequestBody Promocion promocion) {
        return promocionService.savePromocion(promocion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promocion> updatePromocion(@PathVariable int id, @RequestBody Promocion promocion) {
        return promocionService.getPromocionById(id)
                .map(existing -> {
                    promocion.setId(id);
                    return ResponseEntity.ok(promocionService.savePromocion(promocion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromocion(@PathVariable int id) {
        promocionService.deletePromocion(id);
        return ResponseEntity.noContent().build();
    }
}
