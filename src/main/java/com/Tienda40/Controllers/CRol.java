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

import com.Tienda40.Modelo.MRol;
import com.Tienda40.Services.SRol;



@RestController
@RequestMapping("/roles")
public class CRol {

	@Autowired
	SRol rolesS;
	
	@GetMapping
	public ArrayList<MRol> obtener(){
		return rolesS.obtener();
	}
	
	@PostMapping
	public MRol crear(@RequestBody MRol rol) {
		return rolesS.guardar(rol);
	}
	
	@GetMapping(path = "{id}")
	public Optional<MRol> obtenerPorId(@PathVariable("id") int id){
		return rolesS.obtenerPorId(id);
	}
	
	@DeleteMapping(path = "{id}")
	public String eliminarPorId(@PathVariable("id") int id) {
		boolean eliminado = rolesS.eliminar(id);
		if(eliminado) return "Rol Eliminado";
		else return "Error Eliminado Rol";
	}
}
