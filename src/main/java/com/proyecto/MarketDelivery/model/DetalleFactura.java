package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Detalle")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Producto_Id_Producto")
    private Producto producto;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "Precio_Unitario")
    private BigDecimal precioUnitario;

    @Column(name = "Descuento")
    private BigDecimal descuento;

    @Column(name = "Sub__total")
    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "Factura_Id_Factura")
    private Factura factura;

    public DetalleFactura() {}
    // getters / setters...
}
