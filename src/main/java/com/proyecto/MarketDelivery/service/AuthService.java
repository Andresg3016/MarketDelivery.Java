package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.dto.*;
import com.proyecto.MarketDelivery.model.Roles;
import com.proyecto.MarketDelivery.model.Usuario;
import com.proyecto.MarketDelivery.repository.RolesRepository;
import com.proyecto.MarketDelivery.repository.UsuarioRepository;
import com.proyecto.MarketDelivery.security.JwtUtil;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final RolesRepository rolesRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UsuarioRepository usuarioRepository, RolesRepository rolesRepository,
                       AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.rolesRepository = rolesRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String register(RegisterRequest req) {
        if (usuarioRepository.existsByUserName(req.getUsername())) {
            throw new RuntimeException("El username ya existe");
        }
        Usuario u = new Usuario();
        u.setUserName(req.getUsername());
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u.setEmail(req.getEmail());
        u.setNombre1(req.getNombre1());
        u.setApellido1(req.getApellido1());

        // asignar rol por defecto USER
        Roles roles = rolesRepository.findByNombre("ROLES_USER").orElseGet(() -> rolesRepository.save(new Roles("ROLES_USER")));
        u.setRoles(new HashSet<>());
        u.getRoles().add(roles);
        usuarioRepository.save(u);
        return jwtUtil.generateToken(u.getUserName());
    }

    public String login(LoginRequest req) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        Usuario u = usuarioRepository.findByUserName(req.getUsername()).orElseThrow();
        return jwtUtil.generateToken(u.getUserName());
    }
}
