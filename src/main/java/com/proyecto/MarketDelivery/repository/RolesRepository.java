package com.proyecto.MarketDelivery.repository;

import com.proyecto.MarketDelivery.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByNombre(String nombre);
}
