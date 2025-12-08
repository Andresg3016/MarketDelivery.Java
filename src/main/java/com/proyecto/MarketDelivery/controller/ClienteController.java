package com.proyecto.MarketDelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "cliente/cliente-dashboard"; // Vista Thymeleaf
    }
}
