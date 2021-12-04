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

import com.Tienda40.Modelo.MProveedor;
import com.Tienda40.Repositories.RProveedor;
//import com.Tienda40.Services.SProveedor;


@RestController
@RequestMapping("/proveedores")
public class CProveedor {

	@Autowired
	RProveedor proveedoresS;
	
	@GetMapping
	public ArrayList<MProveedor> obtener(){
		return (ArrayList<MProveedor>) proveedoresS.findAll();
	}
	
	@PostMapping
	public MProveedor crear(@RequestBody MProveedor proveedor) {
		return proveedoresS.save(proveedor);
	}
	
	@GetMapping(path = "{id}")
	public Optional<MProveedor> obtenerPorId(@PathVariable("id") Long id){
		return proveedoresS.findById(id);
	}
	
	@DeleteMapping(path = "{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		try {
			Long eliminado = proveedoresS.deleteByIdReturningDeletedCount(id);
			if(eliminado !=0) return "Proveedor Eliminado";
			else return "Error Eliminado Proveedor";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "Error Eliminado Proveedor";
		}
		
	}
}
