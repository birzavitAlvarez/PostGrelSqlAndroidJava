package com.ec4.backend.service;

import java.util.List;
import java.util.Optional;

import com.ec4.backend.entity.Gato;

public interface GatoService {
    public List<Gato> findAll();
	public Optional<Gato> findById(Integer id);
	public void save(Gato gato);
    public void deleteById(Integer id);
}
