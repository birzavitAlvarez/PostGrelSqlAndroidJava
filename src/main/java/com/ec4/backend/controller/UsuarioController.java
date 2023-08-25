package com.ec4.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ec4.backend.DTO.UsuarioDTO;
import com.ec4.backend.entity.Usuario;
import com.ec4.backend.service.UsuarioService;

import java.util.*;


@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity <?> readAll(){
		List<Usuario> ob_usuario = usuarioService.findAll();
		List<UsuarioDTO> ob_usuarioDTO = new ArrayList<>();
		for(Usuario usuario: ob_usuario) {
			UsuarioDTO usuarioDTO = new UsuarioDTO
            (
                usuario.getId(),
                usuario.getUser(),
                usuario.getPassword()                                           
            );
		    ob_usuarioDTO.add(usuarioDTO);
		}
        return ResponseEntity.ok().body(ob_usuarioDTO);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id){
		Optional<Usuario> ob_usuario = usuarioService.findById(id);
		if(!ob_usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		UsuarioDTO ob_usuarioDTO = new UsuarioDTO
        (
            ob_usuario.get().getId(),
            ob_usuario.get().getUser(),
			ob_usuario.get().getPassword()
        );
		return ResponseEntity.ok().body(ob_usuarioDTO);
	}

	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario usuario){
		usuarioService.save(usuario);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);
	}

	/*
{
    "id": 2,
    "user": "gato",
    "password": "123"
}
	 */
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario usuario,@PathVariable Integer id){
		Optional<Usuario> ob_usuario = usuarioService.findById(id);
		if(!ob_usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuario.setId(id);
		usuarioService.save(usuario);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);	
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Usuario> ob_usuario = usuarioService.findById(id);
		if(!ob_usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuarioService.deleteById(id);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);
	}

	// @GetMapping("/login")
    // public ResponseEntity<?> findByUserAndPassword(
    //     @RequestParam String user,
    //     @RequestParam String password
    // ) {
    // 	Usuario ob_usuario = usuarioService.findbyUserAndPassword(user, password);
    //     if (ob_usuario == null) {
    //         Map<String, Object> respuesta = new HashMap<>();
    //         respuesta.put("status", 404);
    //         respuesta.put("message", "Usuario o contraseña incorrectos");
    //         return ResponseEntity.status(404).body(respuesta);
    //     }
    //     UsuarioDTO ob_usuarioDTO = new UsuarioDTO(
    //         ob_usuario.getId(),
    //         ob_usuario.getUser(),
    //         ob_usuario.getPassword()
    //     );
    //     return ResponseEntity.ok().body(ob_usuarioDTO);
    // }

/*
GET http://localhost:8080/api/trabajador/login?user=user_trabajador&password=password_trabajador&ciudadId=id_ciudad
*/

}
