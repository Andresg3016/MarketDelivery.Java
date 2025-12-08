package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Rol;
import com.proyecto.MarketDelivery.model.Usuario;
import com.proyecto.MarketDelivery.service.RolService;
import com.proyecto.MarketDelivery.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Mostrar formulario de registro
    @GetMapping("/register")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.getAllRoles()); // lista de roles desde BD
        return "registro"; // archivo HTML en templates
    }

    // Procesar registro
    @PostMapping("/register")
    public String procesarRegistro(@ModelAttribute Usuario usuario,
                                   @RequestParam String rol,
                                   @RequestParam String confirmPassword,
                                   Model model) {
        // Validar confirmación de contraseña
        if (!usuario.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Las contraseñas no coinciden");
            model.addAttribute("usuario", usuario);
            model.addAttribute("roles", rolService.getAllRoles());
            return "registro";
        }

        try {
            Rol rolAsignado = rolService.findByNombre(rol); // busca el rol por nombre
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            usuario.setRoles(Set.of(rolAsignado));
            usuarioService.saveUsuario(usuario);
            model.addAttribute("success", "Usuario registrado correctamente");
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("error", "Error al registrar usuario: " + e.getMessage());
            model.addAttribute("usuario", usuario);
            model.addAttribute("roles", rolService.getAllRoles());
            return "registro";
        }
    }
}
