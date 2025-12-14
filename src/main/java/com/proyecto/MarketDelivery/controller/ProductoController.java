package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Producto;
import com.proyecto.MarketDelivery.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emprendedor/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Listar productos
    @GetMapping
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.getAllProductos();
        model.addAttribute("productos", productos);
        return "emprendedor-productos"; // Vista Thymeleaf
    }

    // Formulario para crear producto
    @GetMapping("/nuevo")
    public String nuevoProductoForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto_form"; // Vista Thymeleaf
    }

    // Guardar producto
    @PostMapping
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/emprendedor/productos";
    }

    // Formulario para editar producto
    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.getProductoById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        model.addAttribute("producto", producto);
        return "producto_form"; // Reutilizamos el mismo formulario
    }

    // Eliminar producto
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return "redirect:/emprendedor/productos";
    }
}
