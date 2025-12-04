package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogo")
public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Catalogo")
    private Integer id;

    @Column(name = "Descripción")
    private String descripcion;

    public Catalogo() {}
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
