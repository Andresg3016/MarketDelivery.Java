package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Resena;
import com.proyecto.MarketDelivery.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    public List<Resena> getAllReseñas() {
        return resenaRepository.findAll();
    }

    public Optional<Resena> getReseñaById(int id) {
        return resenaRepository.findById(id);
    }

    public Resena saveReseña(Resena r) {
        return resenaRepository.save(r);
    }

    public void deleteReseña(int id) {
        resenaRepository.deleteById(id);
    }
}
