package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pqr")
public class Pqr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Pqr")
    private Integer id;

    @Column(name = "Descripcion_Pqr", nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "Usuario_Id_Usuario", nullable = false)
    private Usuario usuario;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
