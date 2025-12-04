package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Usuario")
    private Integer id;

    @Column(name = "Nombre1_usuario", length = 50)
    private String nombre1;

    @Column(name = "Nombre2_usuario", length = 50)
    private String nombre2;

    @Column(name = "Apellido1_usuario", length = 50)
    private String apellido1;

    @Column(name = "Apellido2_usuario", length = 50)
    private String apellido2;

    @Column(name = "Cedula_usuario", length = 20)
    private String cedula;

    @Column(name = "Email_usuario", length = 100)
    private String email;

    @Column(name = "Telefono_usuario", length = 20)
    private String telefono;

    @Column(name = "Dirección_usuario", length = 100)
    private String direccion;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "user_name", unique = true, length = 255)
    private String userName;

    // Relación con role (muchos a muchos para flexibilidad)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Roles> roles;

    // Carrito (opcional mapping simple)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Carrito_Id_Carrito")
    private Carrito carrito;

    // Emprendimientos: 1 usuario -> muchos emprendimientos
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Emprendimiento> emprendimientos;

    // getters / setters

    public Usuario() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

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

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public Set<Roles> getRoles() { return roles; }
    public void setRoles(Set<Roles> roles) { this.roles = roles; }

    public Carrito getCarrito() { return carrito; }
    public void setCarrito(Carrito carrito) { this.carrito = carrito; }

    public List<Emprendimiento> getEmprendimientos() { return emprendimientos; }
    public void setEmprendimientos(List<Emprendimiento> emprendimientos) { this.emprendimientos = emprendimientos; }
}
