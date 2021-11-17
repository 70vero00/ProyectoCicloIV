package com.Tienda40.Modelo;

import java.util.Objects;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;*/
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//@Entity
//@Table(name="roles")
@Document(collection = "db_rol")
public class MRol {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rol;
	private String tipo;
	public MRol() {
	}
	public MRol(Integer rol, String tipo) {
		this.rol = rol;
		this.tipo = tipo;
	}
	
		
	public Integer getRol() {
		return rol;
	}
	public void setRol(Integer rol) {
		this.rol = rol;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(rol, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MRol other = (MRol) obj;
		return rol == other.rol && Objects.equals(tipo, other.tipo);
	}
	@Override
	public String toString() {
		return "MRol [rol=" + rol + ", tipo=" + tipo + "]";
	}
	
}
