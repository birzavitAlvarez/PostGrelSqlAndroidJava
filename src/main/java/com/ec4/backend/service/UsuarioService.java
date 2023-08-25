package com.ec4.backend.service;

import java.util.List;
import java.util.Optional;

import com.ec4.backend.entity.Usuario;

public interface UsuarioService {
    public List<Usuario> findAll();
	public Optional<Usuario> findById(Integer id);
	public void save(Usuario usuario);
    public void deleteById(Integer id);
    // public Usuario findbyUserAndPassword(String user, String password);
}
