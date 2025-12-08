package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Rol;
import com.proyecto.MarketDelivery.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    // Obtener todos los roles
    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    // Obtener rol por ID (Long)
    public Rol getRolById(Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + id));
    }

    // Guardar rol (crear o actualizar)
    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    // Eliminar rol por ID (Long)
    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }

    // Buscar rol por nombre
    public Rol findByNombre(String nombre) {
        return rolRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + nombre));
    }
}
