package com.Tienda40.Modelo;

import java.util.Objects;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;*/
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//@Entity
//@Table(name="Ventas")
@Document(collection = "db_ventas")
public class MVenta {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_venta;
	//@ManyToOne(optional = false)
	//@JoinColumn(name = "cedula_cliente",nullable=false)
	//private MCliente cliente; 
	private String cliente; 
	//@ManyToOne(optional = false)
	//@JoinColumn(name = "cedula_usuario",nullable=false)
	//private MUsuario usuario;
	private String usuario;
	//@Column(nullable=false)
	private Double iva_venta;
	//@Column(nullable=false)
	private Double total_venta; 
	//@Column(nullable=false)
	private Double valor_venta;
	private String nombre_cliente;
	
	public MVenta(Integer codigo_venta, String cliente, String usuario, Double iva_venta, Double total_venta,
			Double valor_venta, String nombre_cliente) {
		this.codigo_venta = codigo_venta;
		this.cliente = cliente;
		this.usuario = usuario;
		this.iva_venta = iva_venta;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
		this.nombre_cliente = nombre_cliente;
	}
	public MVenta() {
	}
	public Integer getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(Integer codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Double getIva_venta() {
		return iva_venta;
	}
	public void setIva_venta(Double iva_venta) {
		this.iva_venta = iva_venta;
	}
	public Double getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}
	public Double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}
	
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	@Override
	public int hashCode() {
		return Objects.hash( codigo_venta,  cliente, usuario, iva_venta, total_venta, valor_venta, nombre_cliente);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MVenta other = (MVenta) obj;
		return  codigo_venta == other.codigo_venta  && Objects.equals(cliente, other.cliente)
				&& Objects.equals(usuario, other.usuario)
				&& Double.doubleToLongBits(iva_venta) == Double.doubleToLongBits(other.iva_venta)
				&& Double.doubleToLongBits(total_venta) == Double.doubleToLongBits(other.total_venta)				
				&& Double.doubleToLongBits(valor_venta) == Double.doubleToLongBits(other.valor_venta)
				&& Objects.equals(nombre_cliente, other.nombre_cliente);
	}
	@Override
	public String toString() {
		return "MVenta [codigo_venta=" + codigo_venta + ", cliente=" + cliente + ", usuario=" + usuario + ", iva_venta="
				+ iva_venta + ", total_venta=" + total_venta + ", valor_venta=" + valor_venta + ", nombre_cliente="+ nombre_cliente +"]";
	} 
}
