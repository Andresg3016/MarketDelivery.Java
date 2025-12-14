package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "valor_unitario", nullable = false)
    private BigDecimal valorUnitario;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "catalogo_id", nullable = false)
    private Catalogo catalogo;

    @ManyToOne
    @JoinColumn(name = "emprendimiento_id", nullable = false)
    private Emprendimiento emprendimiento;

    @ManyToOne
    @JoinColumn(name = "promocion_id")
    private Promocion promocion;

    public Producto() {}

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

    public Emprendimiento getEmprendimiento() { return emprendimiento; }
    public void setEmprendimiento(Emprendimiento emprendimiento) { this.emprendimiento = emprendimiento; }

    public Promocion getPromocion() { return promocion; }
    public void setPromocion(Promocion promocion) { this.promocion = promocion; }
}
