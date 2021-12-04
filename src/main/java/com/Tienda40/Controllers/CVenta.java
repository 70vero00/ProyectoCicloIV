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

import com.Tienda40.Modelo.MVenta;
import com.Tienda40.Repositories.RVenta;
//import com.Tienda40.Services.SVenta;


@RestController
@RequestMapping("/ventas")
public class CVenta {

	@Autowired
	RVenta ventasS;
	
	@GetMapping
	public ArrayList<MVenta> obtener(){
		return (ArrayList<MVenta>) ventasS.findAll();
	}
	
	@PostMapping
	public MVenta crear(@RequestBody MVenta venta) {
		return ventasS.save(venta);
	}
	
	@GetMapping(path = "{id}")
	public Optional<MVenta> obtenerPorId(@PathVariable("id") Long id){
		return ventasS.findById(id);
	}
	
	@DeleteMapping(path = "{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		try {
			//boolean eliminado = ventasS.eliminar(id);
			Long eliminado = ventasS.deleteByIdReturningDeletedCount(id);
			if(eliminado !=0) return "Venta Eliminado";
			else return "Error Eliminado Venta";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "Error Eliminado Venta";
		}
		
	}
}
