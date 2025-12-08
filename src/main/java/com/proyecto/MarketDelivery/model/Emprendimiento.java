package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "emprendimientos")
public class Emprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Emprendimiento")
    private Long id; // Consistencia con otras entidades

    @Column(name = "Nombre_Emprendimiento", nullable = false)
    private String nombre;

    @Column(name = "tipo_emprendimiento", nullable = false)
    private String tipo;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "Direccion", nullable = false)
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "Usuario_Id_Usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "emprendimiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servicio> servicios;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<Servicio> getServicios() { return servicios; }
    public void setServicios(List<Servicio> servicios) { this.servicios = servicios; }
}
