package com.Tienda40.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tienda40.Modelo.MUsuario;
import com.Tienda40.Repositories.RUsuario;
import com.Tienda40.Services.SUsuario;

@RestController
@RequestMapping("/usuarios")
public class CUsuario {
	@Autowired
	RUsuario usuarioR;
	@Autowired
	SUsuario usuarioS;
	
	@GetMapping("/listar_usuarioR")
	public ArrayList<MUsuario> obtener(){
		return (ArrayList<MUsuario>) usuarioR.findAll();
	}
	
	@PostMapping
	public MUsuario crear(@RequestBody MUsuario usuario) {
		return usuarioR.save(usuario);
	}
	
	@GetMapping(path = "{id}")
	public Optional<MUsuario> obtenerPorId(@PathVariable("id") Long id){
		return usuarioR.findById(id);
	}
	
	@DeleteMapping(path = "{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		try {
			Long eliminado = usuarioR.deleteByIdReturningDeletedCount(id);
			if(eliminado !=0) return "Usuario Eliminado";
			else return "Error Eliminado Usuario";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "Error Eliminado Usuario";
		}
		
	}
	
	@PostMapping(value = "/login")
	public Optional<MUsuario> obtenerLogin(@RequestBody MUsuario usuario){
		return usuarioS.login(usuario.getUsuario(), usuario.getPassword());
	}
}
