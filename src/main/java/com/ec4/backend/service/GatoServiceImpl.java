package com.ec4.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ec4.backend.DAO.GatoDAO;
import com.ec4.backend.entity.Gato;


@Service
public class GatoServiceImpl implements GatoService {

    @Autowired
	private GatoDAO gatoDAO;

    @Override
    @Transactional(readOnly=true)
    public List<Gato> findAll() {
        return gatoDAO.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Gato> findById(Integer id) {
        return gatoDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Gato gato) {
        gatoDAO.save(gato);
    }

    @Override
	@Transactional
	public void deleteById(Integer Id) {
		gatoDAO.deleteById(Id);
	}

    
}
