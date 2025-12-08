package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Emprendimiento;
import com.proyecto.MarketDelivery.service.EmprendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emprendedor/emprendimientos")
public class EmprendimientoController {

    @Autowired
    private EmprendimientoService emprendimientoService;

    // Listar todos los emprendimientos
    @GetMapping
    public String listarEmprendimientos(Model model) {
        List<Emprendimiento> emprendimientos = emprendimientoService.getAllEmprendimientos();
        model.addAttribute("emprendimientos", emprendimientos);
        return "emprendedor-emprendimientos"; // Vista Thymeleaf para listado
    }

    // Formulario para crear un nuevo emprendimiento
    @GetMapping("/nuevo")
    public String nuevoEmprendimientoForm(Model model) {
        model.addAttribute("emprendimiento", new Emprendimiento());
        model.addAttribute("tipos", List.of("Producto", "Servicio")); // ejemplo de tipos
        return "emprendimiento_form"; // 🔥 usa tu archivo existente
    }

    // Guardar emprendimiento (crear o actualizar)
    @PostMapping
    public String guardarEmprendimiento(@ModelAttribute Emprendimiento emprendimiento) {
        emprendimientoService.saveEmprendimiento(emprendimiento);
        return "redirect:/emprendedor/emprendimientos";
    }

    // Formulario para editar emprendimiento
    @GetMapping("/editar/{id}")
    public String editarEmprendimiento(@PathVariable int id, Model model) {
        Emprendimiento emprendimiento = emprendimientoService.getEmprendimientoById(id)
                .orElseThrow(() -> new RuntimeException("Emprendimiento no encontrado"));
        model.addAttribute("emprendimiento", emprendimiento);
        model.addAttribute("tipos", List.of("Producto", "Servicio")); // ejemplo de tipos
        return "emprendimiento_form"; // 🔥 reutiliza tu formulario
    }

    // Eliminar emprendimiento
    @GetMapping("/eliminar/{id}")
    public String eliminarEmprendimiento(@PathVariable int id) {
        emprendimientoService.deleteEmprendimiento(id);
        return "redirect:/emprendedor/emprendimientos";
    }
}
