package com.proyecto.MarketDelivery.security;

import com.proyecto.MarketDelivery.model.Usuario;
import com.proyecto.MarketDelivery.repository.UsuarioRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = usuarioRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        Collection<? extends GrantedAuthority> authorities = u.getRoles() == null ? 
            java.util.Collections.emptyList() :
            u.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getNombre())).collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(u.getUserName(), u.getPassword(), authorities);
    }
}
