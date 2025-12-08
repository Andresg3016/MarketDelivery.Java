package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Servicio;
import com.proyecto.MarketDelivery.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    // Obtener todos los servicios
    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }

    // Obtener servicio por ID (Long)
    public Servicio getServicioById(Long id) {
        return servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado con id: " + id));
    }

    // Guardar servicio
    public Servicio saveServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    // Eliminar servicio por ID (Long)
    public void deleteServicio(Long id) {
        servicioRepository.deleteById(id);
    }
}
