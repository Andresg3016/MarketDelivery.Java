package com.proyecto.MarketDelivery.repository;

import com.proyecto.MarketDelivery.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
}
