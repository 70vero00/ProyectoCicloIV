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
//@Entity
//@Table(name="productos")
@Document(collection = "db_productos")
public class MProducto {

	@Id
	private Long codigo_producto;
	//@Column(nullable=false)
    private Double iva_compra;
	//@JoinColumn(name = "nit_proveedor",nullable=false)
	//@ManyToOne(optional = false)
    //private MProveedor nit_proveedor;
    private Long nit_proveedor;
    private String nombre_producto; 
    //@Column(nullable=false)
    private Double precio_compra;
    //@Column(nullable=false)
    private Double precio_venta;
    
	public MProducto(Long codigo_producto,String nombre_producto,Long nit_proveedor,Double precio_compra,
			 Double iva_compra,Double precio_venta) {
		this.codigo_producto = codigo_producto;
		this.iva_compra = iva_compra;
		this.nit_proveedor = nit_proveedor;
		this.nombre_producto = nombre_producto;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
	}
	public MProducto() {
	}
	
	public Long getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public Double getIva_compra() {
		return iva_compra;
	}
	public void setIva_compra(Double iva_compra) {
		this.iva_compra = iva_compra;
	}
	public Long getNit_proveedor() {
		return nit_proveedor;
	}
	public void setNit_proveedor(Long nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public Double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(Double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public Double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(Double precio_venta) {
		this.precio_venta = precio_venta;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo_producto, iva_compra, nombre_producto, precio_compra, precio_venta, nit_proveedor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MProducto other = (MProducto) obj;
		return codigo_producto == other.codigo_producto
				&& Double.doubleToLongBits(iva_compra) == Double.doubleToLongBits(other.iva_compra)
				&& Objects.equals(nombre_producto, other.nombre_producto)
				&& Double.doubleToLongBits(precio_compra) == Double.doubleToLongBits(other.precio_compra)
				&& Double.doubleToLongBits(precio_venta) == Double.doubleToLongBits(other.precio_venta)
				&& Objects.equals(nit_proveedor, other.nit_proveedor);
	}
	@Override
	public String toString() {
		return "MProducto [codigo_producto=" + codigo_producto + ", iva_compra=" + iva_compra + ", nit_proveedor="
				+ nit_proveedor + ", nombre_producto=" + nombre_producto + ", precio_compra=" + precio_compra
				+ ", precio_venta=" + precio_venta + "]";
	}
}
