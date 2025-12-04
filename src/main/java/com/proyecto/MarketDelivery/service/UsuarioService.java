package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Usuario;
import com.proyecto.MarketDelivery.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo){ this.repo = repo; }

    public List<Usuario> findAll(){ return repo.findAll(); }
    public Usuario findById(Integer id){ return repo.findById(id).orElse(null); }
    public Usuario create(Usuario u){ return repo.save(u); }
    public Usuario update(Integer id, Usuario u){
        u.setId(id);
        return repo.save(u);
    }
    public void delete(Integer id){ repo.deleteById(id); }
}
