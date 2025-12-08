package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Usuario")
    private Long id; // mejor usar Long para consistencia con Rol

    @Column(name = "nombre1_usuario")
    private String nombre1;

    @Column(name = "nombre2_usuario")
    private String nombre2;

    @Column(name = "apellido1_usuario")
    private String apellido1;

    @Column(name = "apellido2_usuario")
    private String apellido2;

    @Column(name = "cedula_usuario")
    private String cedula;

    @Column(name = "email_usuario")
    private String email;

    @Column(name = "telefono_usuario")
    private String telefono;

    @Column(name = "direccion_usuario")
    private String direccion;

    @Column(name = "user_name", nullable = false, unique = true)
    private String username; // coincide con th:field="*{username}"

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "Carrito_Id_Carrito")
    private Carrito carrito;

    @OneToMany(mappedBy = "usuario")
    private List<Pqr> pqrs;

    @OneToMany(mappedBy = "usuario")
    private List<Factura> facturas;

    @OneToMany(mappedBy = "usuario")
    private List<Resena> resenas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuario_roles",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roles = new HashSet<>();

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre1() { return nombre1; }
    public void setNombre1(String nombre1) { this.nombre1 = nombre1; }

    public String getNombre2() { return nombre2; }
    public void setNombre2(String nombre2) { this.nombre2 = nombre2; }

    public String getApellido1() { return apellido1; }
    public void setApellido1(String apellido1) { this.apellido1 = apellido1; }

    public String getApellido2() { return apellido2; }
    public void setApellido2(String apellido2) { this.apellido2 = apellido2; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Carrito getCarrito() { return carrito; }
    public void setCarrito(Carrito carrito) { this.carrito = carrito; }

    public List<Pqr> getPqrs() { return pqrs; }
    public void setPqrs(List<Pqr> pqrs) { this.pqrs = pqrs; }

    public List<Factura> getFacturas() { return facturas; }
    public void setFacturas(List<Factura> facturas) { this.facturas = facturas; }

    public List<Resena> getResenas() { return resenas; }
    public void setResenas(List<Resena> resenas) { this.resenas = resenas; }

    public Set<Rol> getRoles() { return roles; }
    public void setRoles(Set<Rol> roles) { this.roles = roles; }
}
