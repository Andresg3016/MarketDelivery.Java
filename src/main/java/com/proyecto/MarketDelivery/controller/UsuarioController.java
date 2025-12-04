package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Usuario;
import com.proyecto.MarketDelivery.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;
    public UsuarioController(UsuarioService service){ this.service = service; }

    @GetMapping
    public List<Usuario> listar(){ return service.findAll(); }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Integer id){ return service.findById(id); }

    @PostMapping
    public Usuario crear(@RequestBody Usuario u){ return service.create(u); }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Integer id, @RequestBody Usuario u){ return service.update(id, u); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){ service.delete(id); }
}
