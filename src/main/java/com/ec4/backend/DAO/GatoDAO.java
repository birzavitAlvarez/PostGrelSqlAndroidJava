package com.ec4.backend.DAO;

import org.springframework.stereotype.Repository;

import com.ec4.backend.entity.Gato;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GatoDAO extends JpaRepository<Gato,Integer> {
    
}