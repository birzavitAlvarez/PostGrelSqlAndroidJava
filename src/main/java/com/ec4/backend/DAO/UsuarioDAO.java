package com.ec4.backend.DAO;

import org.springframework.stereotype.Repository;
import com.ec4.backend.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario,Integer> {
}