package com.proyecto.MarketDelivery.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Servicio")
    private Integer id;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "Emprendimiento_Id_Emprendimiento", nullable = false)
    private Emprendimiento emprendimiento;

    @ManyToOne
    @JoinColumn(name = "Catalogo_Id_Catalogo", nullable = false)
    private Catalogo catalogo;

    @OneToMany(mappedBy = "servicio")
    private List<Agenda> agendas;

    @OneToMany(mappedBy = "servicio")
    private List<Carrito> carritos;

    // Commented to avoid circular dependency: Servicio <-> Factura
    // @OneToMany(mappedBy = "servicio")
    // private List<Factura> facturas;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Emprendimiento getEmprendimiento() { return emprendimiento; }
    public void setEmprendimiento(Emprendimiento emprendimiento) { this.emprendimiento = emprendimiento; }

    public Catalogo getCatalogo() { return catalogo; }
    public void setCatalogo(Catalogo catalogo) { this.catalogo = catalogo; }

    public List<Agenda> getAgendas() { return agendas; }
    public void setAgendas(List<Agenda> agendas) { this.agendas = agendas; }

    public List<Carrito> getCarritos() { return carritos; }
    public void setCarritos(List<Carrito> carritos) { this.carritos = carritos; }

    // Commented to avoid circular dependency: Servicio <-> Factura
    // public List<Factura> getFacturas() { return facturas; }
    // public void setFacturas(List<Factura> facturas) { this.facturas = facturas; }
}
