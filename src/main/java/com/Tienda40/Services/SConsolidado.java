package com.Tienda40.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tienda40.Modelo.Consolidado;

import com.Tienda40.Repositories.RConsolidado;

@Service
public class SConsolidado {

	@Autowired
	RConsolidado consolidadoR;
	
	public Consolidado guardar(Consolidado consolidado) {
		return consolidadoR.save(consolidado);
	}
	
	public Optional<Consolidado> obtenerPorId(Integer id){
		return consolidadoR.findById(id);
	}
	
	public ArrayList<Consolidado> obtener(){
		return (ArrayList<Consolidado>) consolidadoR.findAll();
	}
	
	public boolean eliminar(Integer id) {
		try {
			consolidadoR.deleteById(id);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

