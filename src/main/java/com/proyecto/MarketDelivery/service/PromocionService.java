package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Promocion;
import com.proyecto.MarketDelivery.repository.PromocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromocionService {

    @Autowired
    private PromocionRepository promocionRepository;

    public List<Promocion> getAllPromociones() {
        return promocionRepository.findAll();
    }

    public Optional<Promocion> getPromocionById(int id) {
        return promocionRepository.findById(id);
    }

    public Promocion savePromocion(Promocion p) {
        return promocionRepository.save(p);
    }

    public void deletePromocion(int id) {
        promocionRepository.deleteById(id);
    }
}

