
package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "emprendimiento_id", nullable = false)
    private Emprendimiento emprendimiento;

    @ManyToOne
    @JoinColumn(name = "catalogo_id", nullable = false)
    private Catalogo catalogo;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    public Servicio() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Emprendimiento getEmprendimiento() { return emprendimiento; }
    public void setEmprendimiento(Emprendimiento emprendimiento) { this.emprendimiento = emprendimiento; }

    public Catalogo getCatalogo() { return catalogo; }
    public void setCatalogo(Catalogo catalogo) { this.catalogo = catalogo; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
}
