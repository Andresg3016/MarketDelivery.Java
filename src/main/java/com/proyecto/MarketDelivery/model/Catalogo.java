package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "catalogo")
public class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_catalogo")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "descripcion_larga")
    private String descripcionLarga;

    public Catalogo() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getDescripcionLarga() { return descripcionLarga; }
    public void setDescripcionLarga(String descripcionLarga) { this.descripcionLarga = descripcionLarga; }
}
