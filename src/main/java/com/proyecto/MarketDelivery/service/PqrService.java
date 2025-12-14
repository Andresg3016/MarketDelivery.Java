package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Pqr;
import com.proyecto.MarketDelivery.repository.PqrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PqrService {

    @Autowired
    private PqrRepository pqrRepository;

    public List<Pqr> getAllPqrs() {
        return pqrRepository.findAll();
    }

    public Optional<Pqr> getPqrById(Long id) {
        return pqrRepository.findById(id);
    }

    public Pqr savePqr(Pqr pqr) {
        return pqrRepository.save(pqr);
    }

    public void deletePqr(Long id) {
        pqrRepository.deleteById(id);
    }
}
