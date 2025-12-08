package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Usuario;
import com.proyecto.MarketDelivery.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario,
                                            @RequestParam String rol) {
        Usuario nuevo = usuarioService.registrarUsuario(usuario, rol);
        return ResponseEntity.ok(nuevo);
    }
}
