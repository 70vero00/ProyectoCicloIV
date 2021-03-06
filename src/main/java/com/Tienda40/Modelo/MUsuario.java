package com.Tienda40.Modelo;

import java.util.Objects;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;*/
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
//@Table(name="usuarios")
@Document(collection = "db_usuarios")
public class MUsuario {

	@Id
	//@Column(nullable=false)
	private long cedula_usuario;
	private String email_usuario;
	private String nombre_usuario; 
	private String password;
	private String usuario;
	//@JoinColumn(name = "rol",nullable=false)
	
	//@ManyToOne(optional = false)
	//private MRol rol;
	private Integer rol;
	//public MUsuario(long cedula_usuario, String email_usuario, String nombre_usuario, String password, String usuario,	MRol rol)
	public MUsuario(long cedula_usuario, String email_usuario, String nombre_usuario, String password, String usuario,	Integer rol)
	
	{
		this.cedula_usuario = cedula_usuario;
		this.email_usuario = email_usuario;
		this.nombre_usuario = nombre_usuario;
		this.password = password;
		this.usuario = usuario;
		this.rol = rol;
	}
	public MUsuario(String usuario,String password) {
		this.usuario = usuario;
		this.password = password;
	}
	public MUsuario() {
	}
	public long getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	//@JsonIgnore
	public Integer getRol() {
		return rol;
	}
	public void setRol(Integer rol) {
		this.rol = rol;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cedula_usuario, email_usuario, nombre_usuario, password, usuario, rol);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MUsuario other = (MUsuario) obj;
		return cedula_usuario == other.cedula_usuario && Objects.equals(email_usuario, other.email_usuario)
				&& Objects.equals(nombre_usuario, other.nombre_usuario) && Objects.equals(password, other.password)
				&& Objects.equals(usuario, other.usuario) && Objects.equals(rol, other.rol) ;
	}
	@Override
	public String toString() {
		return "MUsuario [cedula_usuario=" + cedula_usuario + ", email_usuario=" + email_usuario + ", nombre_usuario="
				+ nombre_usuario + ", password=" + password + ", usuario=" + usuario + ", rol=" + rol + "]";
		
	}
}
