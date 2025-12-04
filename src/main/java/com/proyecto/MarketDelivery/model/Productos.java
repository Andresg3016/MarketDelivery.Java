package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "productos")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Producto")
    private Integer id;

    @Column(name = "Nombre", nullable=false)
    private String nombre;

    @Column(name = "Valor_Unitario", nullable=false)
    private BigDecimal valorUnitario;

    @Column(name = "Descripción")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "Catálogo_Id_Catálogo")
    private Catalogo catalogo;

    @Column(name = "Stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "Promoción_Id_Promoción")
    private Promocion promocion;

    public Productos() {}

    // getters / setters...
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public BigDecimal getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(BigDecimal valorUnitario) { this.valorUnitario = valorUnitario; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Catalogo getCatalogo() { return catalogo; }
    public void setCatalogo(Catalogo catalogo) { this.catalogo = catalogo; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public Promocion getPromocion() { return promocion; }
    public void setPromocion(Promocion promocion) { this.promocion = promocion; }
}
