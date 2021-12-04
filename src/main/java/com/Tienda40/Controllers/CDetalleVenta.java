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

import com.Tienda40.Modelo.MDetalleVenta;
import com.Tienda40.Repositories.RDetalleVenta;
//import com.Tienda40.Services.SDetalleVenta;


@RestController
@RequestMapping("/DetalleVentas")
public class CDetalleVenta {

	@Autowired
	RDetalleVenta DetalleS;
	
	@GetMapping
	public ArrayList<MDetalleVenta> obtener(){
		return (ArrayList<MDetalleVenta>) DetalleS.findAll();
	}
	
	@PostMapping
	public MDetalleVenta crear(@RequestBody MDetalleVenta detalle) {
		return DetalleS.save(detalle);
	}
	
	@PostMapping(path="/Todos")
	public ArrayList<MDetalleVenta> crearTodos(@RequestBody ArrayList<MDetalleVenta> detalles){
		return (ArrayList<MDetalleVenta>) DetalleS.saveAll(detalles);
	}
	
	
	@GetMapping(path = "{id}")
	public Optional<MDetalleVenta> obtenerPorId(@PathVariable("id") Long id){
		return DetalleS.findById(id);
	}
	
	@DeleteMapping(path = "{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		try {
			Long eliminado = DetalleS.deleteByIdReturningDeletedCount(id);
			if(eliminado !=0) return "Detalle Ventas Eliminado";
			else return "Error Eliminado Detalle Ventas";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "Error Eliminado Detalle Ventas";
		}
	}
}
