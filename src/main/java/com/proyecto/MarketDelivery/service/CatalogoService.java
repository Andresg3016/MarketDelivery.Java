package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Catalogo;
import com.proyecto.MarketDelivery.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoService {

    @Autowired
    private CatalogoRepository catalogoRepository;

    // Obtener todos los catálogos
    public List<Catalogo> getAllCatalogos() {
        return catalogoRepository.findAll();
    }

    // Obtener catálogo por ID (Long)
    public Catalogo getCatalogoById(Long id) {
        return catalogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catálogo no encontrado con id: " + id));
    }

    // Guardar catálogo
    public Catalogo saveCatalogo(Catalogo c) {
        return catalogoRepository.save(c);
    }

    // Eliminar catálogo por ID (Long)
    public void deleteCatalogo(Long id) {
        catalogoRepository.deleteById(id);
    }
}
