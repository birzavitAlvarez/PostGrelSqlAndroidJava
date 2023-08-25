package com.ec4.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ec4.backend.DAO.UsuarioDAO;
import com.ec4.backend.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
	private UsuarioDAO usuarioDAO;

    @Override
    @Transactional(readOnly=true)
    public List<Usuario> findAll() {
        return usuarioDAO.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Usuario> findById(Integer id) {
        return usuarioDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
	@Transactional
	public void deleteById(Integer Id) {
		usuarioDAO.deleteById(Id);
	}

    // @Override
    // @Transactional(readOnly = true)
    // public Usuario findbyUserAndPassword(String user, String password) {
    //     return usuarioDAO.findbyUserAndPassword(user, password);
    // }	
}
