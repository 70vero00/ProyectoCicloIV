package com.Tienda40.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tienda40.Modelo.Consolidado;

import com.Tienda40.Services.SConsolidado;

@RestController
@RequestMapping("/consolidado")
@CrossOrigin("*")
public class CConsolidado {
	@Autowired
	SConsolidado consolidadoS;
	
	@GetMapping
	public ArrayList<Consolidado> obtener(){
		return consolidadoS.obtener();
	}
	
	@PostMapping
	public Consolidado crear(@RequestBody Consolidado consolidado) {
		return consolidadoS.guardar(consolidado);
	}
	
	@GetMapping(path = "{id}")
	public Optional<Consolidado> obtenerPorId(@PathVariable("id") Integer id){
		return consolidadoS.obtenerPorId(id);
	}
	
	@DeleteMapping(path = "{id}")
	public String eliminarPorId(@PathVariable("id") Integer id) {
		boolean eliminado = consolidadoS.eliminar(id);
		if(eliminado) return "Cliente Eliminado";
		else return "Error Eliminado Cliente";
	}
}

