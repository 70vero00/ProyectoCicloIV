package com.Tienda40.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Tienda40.Modelo.MProducto;
import com.Tienda40.Repositories.RProducto;
import com.Tienda40.Services.SCsv;
import com.Tienda40.Services.SCsvHelper;
//import com.Tienda40.Services.SProducto;

import org.springframework.http.MediaType;



@RestController
@RequestMapping("/productos")
public class CProducto {

	@Autowired
	RProducto productosS;
	@Autowired
	SCsv csv;
	
	@GetMapping
	public ArrayList<MProducto> obtener(){
		return (ArrayList<MProducto>) productosS.findAll();
	}
	
	@PostMapping  
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	  
	    if (SCsvHelper.hasCSVFormat(file)) {
	      try {
	        csv.save(file);

	        message = "Carga del archivo exitosa";
	        
	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/productos/download/")
	                .path(file.getOriginalFilename())
	                .toUriString();

	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message,fileDownloadUri));
	      } catch (Exception e) {
	        message = "No se puede subir archivo!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message,""));
	      }
	    }

	    message = "Agregue un archivo .csv";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message,""));
     
    
  
    }
	
	@GetMapping("/prods")
	  public ResponseEntity<List<MProducto>> getAllTutorials() {
	    try {
	      List<MProducto> prods = csv.getAllProds();

	      if (prods.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(prods, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @GetMapping("/download/{fileName:.+}")
	  public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
	    InputStreamResource file = new InputStreamResource(csv.load());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }
	
	@GetMapping(path = "{id}")
	public Optional<MProducto> obtenerPorId(@PathVariable("id") Long id){
		return productosS.findById(id);
	}
	
	/*
	@DeleteMapping
	public String eliminar() {
		//boolean eliminado = productosS.eliminarTodos();
		//if(eliminado) return "Productos Eliminados";
		//else return "Error Eliminado Productos";
		
	}
	*/
	
	@DeleteMapping(path = "{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		try {
			Long eliminado = productosS.deleteByIdReturningDeletedCount(id);
			//boolean eliminado = productosS.eliminar(id);
			if(eliminado !=0) return "Producto Eliminado";
			else return "Error Eliminado Producto";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "Error Eliminado Producto";
		}
		
	}
	
	@PostMapping(path = "/agregar")
	public MProducto guardar(@RequestBody MProducto producto){
		return productosS.save(producto);
	}
	
	/*@PostMapping
	public MProducto crear(@RequestBody MProducto producto) {
		return productosS.guardar(producto);
	}*/
	
}
