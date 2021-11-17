package com.Tienda18.Modelo;

import java.util.Objects;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//@Entity
//@Table(name="clientes")
@Document(collection = "db_clientes")
public class MCliente {
	@Id
	//@Column(nullable=false)
	private long cedula_cliente;
	private String direccion_cliente;
	private String email_cliente;
	private String nombre_cliente;
	private String telefono_cliente;
	public MCliente() {
	}
	public MCliente(long cedula_cliente, String direccion_cliente, String email_cliente, String nombre_cliente,
			String telefono_cliente) {
		this.cedula_cliente = cedula_cliente;
		this.direccion_cliente = direccion_cliente;
		this.email_cliente = email_cliente;
		this.nombre_cliente = nombre_cliente;
		this.telefono_cliente = telefono_cliente;
	}
	public long getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public String getDireccion_cliente() {
		return direccion_cliente;
	}
	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}
	public String getEmail_cliente() {
		return email_cliente;
	}
	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public String getTelefono_cliente() {
		return telefono_cliente;
	}
	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cedula_cliente, direccion_cliente, email_cliente, nombre_cliente, telefono_cliente);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MCliente other = (MCliente) obj;
		return cedula_cliente == other.cedula_cliente && Objects.equals(direccion_cliente, other.direccion_cliente)
				&& Objects.equals(email_cliente, other.email_cliente)
				&& Objects.equals(nombre_cliente, other.nombre_cliente)
				&& Objects.equals(telefono_cliente, other.telefono_cliente);
	}
	@Override
	public String toString() {
		return "MCliente [cedula_cliente=" + cedula_cliente + ", direccion_cliente=" + direccion_cliente
				+ ", email_cliente=" + email_cliente + ", nombre_cliente=" + nombre_cliente + ", telefono_cliente="
				+ telefono_cliente + "]";
	}
	
}