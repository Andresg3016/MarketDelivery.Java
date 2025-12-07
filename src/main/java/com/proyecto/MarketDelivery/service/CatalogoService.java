package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Catalogo;
import com.proyecto.MarketDelivery.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoService {

    @Autowired
    private CatalogoRepository catalogoRepository;

    public List<Catalogo> getAllCatalogos() {
        return catalogoRepository.findAll();
    }

    public Optional<Catalogo> getCatalogoById(int id) {
        return catalogoRepository.findById(id);
    }

    public Catalogo saveCatalogo(Catalogo c) {
        return catalogoRepository.save(c);
    }

    public void deleteCatalogo(int id) {
        catalogoRepository.deleteById(id);
    }
}
