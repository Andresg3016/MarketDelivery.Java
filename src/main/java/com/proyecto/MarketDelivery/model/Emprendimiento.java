package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "emprendimientos")
public class Emprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Emprendimiento")
    private Integer id;

    @Column(name = "Nombre_Emprendimiento", nullable = false)
    private String nombre;

    @Column(name = "Tipo_Emprendimiento", nullable = false)
    private String tipo;

    @Column(name = "Descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "Ciudad", nullable = false)
    private String ciudad;

    @Column(name = "Direccion", nullable = false)
    private String direccion;

    @Column(name = "Telefono")
    private String telefono;

    // Relación correcta: cada emprendimiento pertenece a un usuario
    @ManyToOne
    @JoinColumn(name = "Usuario_Id_Usuario")
    private Usuario usuario;

    public Emprendimiento() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

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
}
