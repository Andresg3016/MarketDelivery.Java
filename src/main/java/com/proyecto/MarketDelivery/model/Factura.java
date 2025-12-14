package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "iva")
    private BigDecimal iva;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "fecha", nullable = false)
    private java.time.LocalDateTime fecha;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<DetalleFactura> detalles;

    public Factura() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getIva() { return iva; }
    public void setIva(BigDecimal iva) { this.iva = iva; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public java.time.LocalDateTime getFecha() { return fecha; }
    public void setFecha(java.time.LocalDateTime fecha) { this.fecha = fecha; }

    public java.util.List<DetalleFactura> getDetalles() { return detalles; }
    public void setDetalles(java.util.List<DetalleFactura> detalles) { this.detalles = detalles; }
}
