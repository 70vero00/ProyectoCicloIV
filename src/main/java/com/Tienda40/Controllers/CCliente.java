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

import com.Tienda40.Modelo.MCliente;
import com.Tienda40.Repositories.RCliente;
//import com.Tienda40.Services.SCliente;



@RestController
@RequestMapping("/clientes")
public class CCliente {
	@Autowired
	//SCliente clienteS;
	RCliente clienteS;
	
	@GetMapping
	public ArrayList<MCliente> obtener(){
		//return clienteS.obtener();
		return (ArrayList<MCliente>) clienteS.findAll();
	}
	
	@PostMapping
	public MCliente crear(@RequestBody MCliente cliente) {
		//return clienteS.guardar(cliente);
		return clienteS.save(cliente);
	}
	
	@GetMapping(path = "{id}")
	public Optional<MCliente> obtenerPorId(@PathVariable("id") Long id){
		return clienteS.findById(id);
	}
	
	@DeleteMapping(path = "{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		try {
			//clienteS.deleteById(id);
			Long eliminado = clienteS.deleteByIdReturningDeletedCount(id);
			//System.out.println(eliminado);
			if(eliminado !=0) return "Cliente Eliminado";
			else return "Error Eliminado Cliente";
			//return "Cliente Eliminado";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "Error Eliminado Cliente";
		}
		/*boolean eliminado = clienteS.eliminar(id);
		System.out.println(eliminado);
		if(eliminado) return "Cliente Eliminado";
		else return "Error Eliminado Cliente"; */
	}
}
