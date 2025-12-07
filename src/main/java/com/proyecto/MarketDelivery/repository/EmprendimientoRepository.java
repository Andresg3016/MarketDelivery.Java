package com.proyecto.MarketDelivery.repository;

import com.proyecto.MarketDelivery.model.Emprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Integer> {
}
    