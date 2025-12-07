package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Emprendimiento;
import com.proyecto.MarketDelivery.service.EmprendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprendimientos")
public class EmprendimientoController {

    @Autowired
    private EmprendimientoService emprendimientoService;

    @GetMapping
    public List<Emprendimiento> getAllEmprendimientos() {
        return emprendimientoService.getAllEmprendimientos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprendimiento> getEmprendimientoById(@PathVariable int id) {
        return emprendimientoService.getEmprendimientoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Emprendimiento createEmprendimiento(@RequestBody Emprendimiento emprendimiento) {
        return emprendimientoService.saveEmprendimiento(emprendimiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprendimiento> updateEmprendimiento(@PathVariable int id, @RequestBody Emprendimiento emprendimiento) {
        return emprendimientoService.getEmprendimientoById(id)
                .map(existing -> {
                    emprendimiento.setId(id);
                    return ResponseEntity.ok(emprendimientoService.saveEmprendimiento(emprendimiento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmprendimiento(@PathVariable int id) {
        emprendimientoService.deleteEmprendimiento(id);
        return ResponseEntity.noContent().build();
    }
}
