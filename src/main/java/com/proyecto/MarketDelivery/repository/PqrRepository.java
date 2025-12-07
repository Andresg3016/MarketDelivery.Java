package com.proyecto.MarketDelivery.repository;

import com.proyecto.MarketDelivery.model.Pqr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PqrRepository extends JpaRepository<Pqr, Integer> {
}
