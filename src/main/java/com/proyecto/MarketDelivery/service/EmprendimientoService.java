package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Emprendimiento;
import com.proyecto.MarketDelivery.repository.EmprendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprendimientoService {

    @Autowired
    private EmprendimientoRepository emprendimientoRepository;

    public List<Emprendimiento> getAllEmprendimientos() {
        return emprendimientoRepository.findAll();
    }

    public Optional<Emprendimiento> getEmprendimientoById(long id) {
        return emprendimientoRepository.findById(id);
    }

    public Emprendimiento saveEmprendimiento(Emprendimiento e) {
        return emprendimientoRepository.save(e);
    }

    public void deleteEmprendimiento(long id) {
        emprendimientoRepository.deleteById(id);
    }
}
