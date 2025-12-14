package com.proyecto.MarketDelivery.repository;

import com.proyecto.MarketDelivery.model.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Long> {
}
