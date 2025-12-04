package com.proyecto.MarketDelivery.repository;

import com.proyecto.MarketDelivery.model.Emprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Integer> {
    List<Emprendimiento> findByUsuarioId(Integer usuarioId);
}
