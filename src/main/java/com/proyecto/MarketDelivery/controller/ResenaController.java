package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Resena;
import com.proyecto.MarketDelivery.service.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @GetMapping
    public List<Resena> getAllReseñas() {
        return resenaService.getAllReseñas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resena> getReseñaById(@PathVariable Long id) {
        return resenaService.getReseñaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Resena createReseña(@RequestBody Resena resena) {
        return resenaService.saveReseña(resena);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resena> updateReseña(@PathVariable Long id, @RequestBody Resena resena) {
        return resenaService.getReseñaById(id)
                .map(existing -> {
                    resena.setId(id);
                    return ResponseEntity.ok(resenaService.saveReseña(resena));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReseña(@PathVariable Long id) {
        resenaService.deleteReseña(id);
        return ResponseEntity.noContent().build();
    }
}
