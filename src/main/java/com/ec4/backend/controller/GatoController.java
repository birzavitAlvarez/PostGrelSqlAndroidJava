package com.ec4.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec4.backend.DTO.GatoDTO;
import com.ec4.backend.entity.Gato;
import com.ec4.backend.service.GatoService;


@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/gato")
public class GatoController {

     @Autowired
	private GatoService gatoService;

	@GetMapping
	public ResponseEntity <?> readAll(){
		List<Gato> ob_gato = gatoService.findAll();
		List<GatoDTO> ob_gatoDTO = new ArrayList<>();
		for(Gato gato: ob_gato) {
			GatoDTO gatoDTO = new GatoDTO
            (
                gato.getId(),
                gato.getImagen(),
                gato.getNombre(),
                gato.getRaza(),
                gato.getEdad(),
                gato.getComida(),
                gato.getPais(),
                gato.getFavorito()                                         
            );
		    ob_gatoDTO.add(gatoDTO);
		}
        return ResponseEntity.ok().body(ob_gatoDTO);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id){
		Optional<Gato> ob_gato = gatoService.findById(id);
		if(!ob_gato.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		GatoDTO ob_gatoDTO = new GatoDTO
        (
            ob_gato.get().getId(),
            ob_gato.get().getImagen(),
            ob_gato.get().getNombre(),
            ob_gato.get().getRaza(),
            ob_gato.get().getEdad(),
            ob_gato.get().getComida(),
            ob_gato.get().getPais(),
            ob_gato.get().getFavorito()
            
        );
		return ResponseEntity.ok().body(ob_gatoDTO);
	}

	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Gato gato){
		gatoService.save(gato);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);
	}

	/*
	{
		"user": "birzavit2",
		"password": "birzavit2",
		"ciudad":{
			"id":1
		}
	}
	 */
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Gato gato,@PathVariable Integer id){
		Optional<Gato> ob_gato = gatoService.findById(id);
		if(!ob_gato.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		gato.setId(id);
		gatoService.save(gato);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);	
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Gato> ob_gato = gatoService.findById(id);
		if(!ob_gato.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		gatoService.deleteById(id);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);
	}
    
}
