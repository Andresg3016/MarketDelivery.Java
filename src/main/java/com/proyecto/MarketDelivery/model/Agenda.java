package com.proyecto.MarketDelivery.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Agenda")
    private Long id;

    @Column(name = "Disponibilidad", nullable = false)
    private LocalDateTime disponibilidad;

    @ManyToOne
    @JoinColumn(name = "Servicio_Id_Servicio", nullable = false)
    private Servicio servicio;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(LocalDateTime disponibilidad) { this.disponibilidad = disponibilidad; }

    public Servicio getServicio() { return servicio; }
    public void setServicio(Servicio servicio) { this.servicio = servicio; }
}