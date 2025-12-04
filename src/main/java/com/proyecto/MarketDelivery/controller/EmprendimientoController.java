package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Emprendimiento;
import com.proyecto.MarketDelivery.repository.EmprendimientoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprendimientos")
public class EmprendimientoController {

    private final EmprendimientoRepository repo;
    public EmprendimientoController(EmprendimientoRepository repo){ this.repo = repo; }

    @GetMapping
    public List<Emprendimiento> all(){ return repo.findAll(); }

    @GetMapping("/{id}")
    public Emprendimiento get(@PathVariable Integer id){ return repo.findById(id).orElse(null); }

    @PostMapping
    public Emprendimiento create(@RequestBody Emprendimiento e){ return repo.save(e); }

    @PutMapping("/{id}")
    public Emprendimiento update(@PathVariable Integer id, @RequestBody Emprendimiento e){
        e.setId(id);
        return repo.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ repo.deleteById(id); }
}
