package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Usuario;
import com.proyecto.MarketDelivery.model.Emprendimiento;
import com.proyecto.MarketDelivery.model.Producto;
import com.proyecto.MarketDelivery.model.Servicio;
import com.proyecto.MarketDelivery.service.UsuarioService;
import com.proyecto.MarketDelivery.service.EmprendimientoService;
import com.proyecto.MarketDelivery.service.ProductoService;
import com.proyecto.MarketDelivery.service.ServicioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emprendedor")
public class EmprendedorDashboardController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmprendimientoService emprendimientoService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        // Obtener el usuario autenticado
        Usuario usuario = usuarioService.findByUsername(userDetails.getUsername());

        // Cargar listas
        List<Emprendimiento> emprendimientos = emprendimientoService.getAllEmprendimientos();
        List<Producto> productos = productoService.getAllProductos();
        List<Servicio> servicios = servicioService.getAllServicios();

        // Pasar datos al modelo
        model.addAttribute("usuario", usuario);
        model.addAttribute("emprendimientos", emprendimientos);
        model.addAttribute("productos", productos);
        model.addAttribute("servicios", servicios);

        return "emprendedor/emprendedor-dashboard"; // Vista Thymeleaf
    }
}
