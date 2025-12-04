package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Factura")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Usuario_Id_Usuario", nullable=false)
    private Usuario usuario;

    @Column(name = "Descripción")
    private String descripcion;

    @Column(name = "Iva")
    private BigDecimal iva;

    @Column(name = "Valor_Total")
    private BigDecimal valorTotal;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<DetalleFactura> detalles;

    public Factura() {}
    // getters / setters...
}
