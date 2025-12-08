package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Producto")
    private Long id; // Consistencia con otras entidades

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Valor_Unitario", nullable = false)
    private BigDecimal valorUnitario;

    @Column(name = "Descripción")
    private String descripcion;

    @Column(name = "Stock")
    private Integer stock;

    // Relación con Catalogo
    @ManyToOne
    @JoinColumn(name = "Catalogo_Id_Catalogo", nullable = false)
    private Catalogo catalogo;

    public Producto() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public BigDecimal getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(BigDecimal valorUnitario) { this.valorUnitario = valorUnitario; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Catalogo getCatalogo() { return catalogo; }
    public void setCatalogo(Catalogo catalogo) { this.catalogo = catalogo; }
}
