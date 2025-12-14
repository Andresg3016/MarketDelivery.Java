package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Pqr;
import com.proyecto.MarketDelivery.service.PqrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pqrs")
public class PqrController {

    @Autowired
    private PqrService pqrService;

    @GetMapping
    public List<Pqr> getAllPqrs() {
        return pqrService.getAllPqrs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pqr> getPqrById(@PathVariable Long id) {
        return pqrService.getPqrById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pqr createPqr(@RequestBody Pqr pqr) {
        return pqrService.savePqr(pqr);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pqr> updatePqr(@PathVariable Long id, @RequestBody Pqr pqr) {
        return pqrService.getPqrById(id)
                .map(existing -> {
                    pqr.setId(id);
                    return ResponseEntity.ok(pqrService.savePqr(pqr));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePqr(@PathVariable Long id) {
        pqrService.deletePqr(id);
        return ResponseEntity.noContent().build();
    }
}
