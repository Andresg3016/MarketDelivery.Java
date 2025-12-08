package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Servicio;
import com.proyecto.MarketDelivery.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emprendedor/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    // Listar servicios
    @GetMapping
    public String listarServicios(Model model) {
        List<Servicio> servicios = servicioService.getAllServicios();
        model.addAttribute("servicios", servicios);
        return "emprendedor-servicios"; // Vista Thymeleaf
    }

    // Formulario para crear servicio
    @GetMapping("/nuevo")
    public String nuevoServicioForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicio_form"; // Vista Thymeleaf
    }

    // Guardar servicio
    @PostMapping
    public String guardarServicio(@ModelAttribute Servicio servicio) {
        servicioService.saveServicio(servicio);
        return "redirect:/emprendedor/servicios";
    }

    // Formulario para editar servicio
    @GetMapping("/editar/{id}")
    public String editarServicio(@PathVariable Long id, Model model) {
        Servicio servicio = servicioService.getServicioById(id);
        model.addAttribute("servicio", servicio);
        return "servicio_form"; // Reutilizamos el mismo formulario
    }

    // Eliminar servicio
    @GetMapping("/eliminar/{id}")
    public String eliminarServicio(@PathVariable Long id) {
        servicioService.deleteServicio(id);
        return "redirect:/emprendedor/servicios";
    }
}
