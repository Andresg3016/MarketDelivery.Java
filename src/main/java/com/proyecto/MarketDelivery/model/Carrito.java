package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Carrito")
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Carrito_Id_Carrito")
    private List<DetalleFactura> items; // o una entidad DetalleCarrito según prefieras

    @Column(name = "Total")
    private BigDecimal total;

    public Carrito() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public List<DetalleFactura> getItems() { return items; }
    public void setItems(List<DetalleFactura> items) { this.items = items; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
