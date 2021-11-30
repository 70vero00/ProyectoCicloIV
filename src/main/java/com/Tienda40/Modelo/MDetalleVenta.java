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
//@Table(name="Detalle_Ventas")
@Document(collection = "db_detalle_ventas")
public class MDetalleVenta {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_detalle_venta; 
	//@Column(nullable=false)
	private Integer cantidad_producto; 
	//@ManyToOne(optional = false)
	//@JoinColumn(name = "codigo_producto",nullable=false)
	//private MProducto producto;
	private Integer producto;
	//@ManyToOne(optional = false)
	//@JoinColumn(name = "codigo_venta",nullable=false)
	//private MVenta venta;
	private Double venta;
	//@Column(nullable=false)
	private Double valor_total;
	//@Column(nullable=false)
	private Double valor_venta;
	//@Column(nullable=false)
	private Double valor_iva;
	public MDetalleVenta(Integer codigo_detalle_venta, Integer cantidad_producto, Integer producto, Double venta,
			Double valor_total, Double valor_venta, Double valor_iva) {
		this.codigo_detalle_venta = codigo_detalle_venta;
		this.cantidad_producto = cantidad_producto;
		this.producto = producto;
		this.venta = venta;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
		this.valor_iva = valor_iva;
	}
	public MDetalleVenta() {
	}
	public Integer getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}
	public void setCodigo_detalle_venta(Integer codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}
	public Integer getCantidad_producto() {
		return cantidad_producto;
	}
	public void setCantidad_producto(Integer cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	public Integer getProducto() {
		return producto;
	}
	public void setProducto(Integer producto) {
		this.producto = producto;
	}
	public Double getVenta() {
		return venta;
	}
	public void setVenta(Double venta) {
		this.venta = venta;
	}
	public Double getValor_total() {
		return valor_total;
	}
	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}
	public Double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}
	public Double getValor_iva() {
		return valor_iva;
	}
	public void setValor_iva(Double valor_iva) {
		this.valor_iva = valor_iva;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo_detalle_venta, cantidad_producto,  producto, venta, valor_total, valor_venta, valor_iva  
				);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MDetalleVenta other = (MDetalleVenta) obj;
		return codigo_detalle_venta == other.codigo_detalle_venta
				&& cantidad_producto == other.cantidad_producto 
				&& Objects.equals(producto, other.producto)
				&& Objects.equals(venta, other.venta)
				&& Double.doubleToLongBits(valor_total) == Double.doubleToLongBits(other.valor_total)
				&& Double.doubleToLongBits(valor_venta) == Double.doubleToLongBits(other.valor_venta)
				&& Double.doubleToLongBits(valor_iva) == Double.doubleToLongBits(other.valor_iva);
	}
	@Override
	public String toString() {
		return "MDetalleVenta [codigo_detalle_venta=" + codigo_detalle_venta + ", cantidad_producto="
				+ cantidad_producto + ", producto=" + producto + ", venta=" + venta + ", valor_total=" + valor_total
				+ ", valor_venta=" + valor_venta + ", valor_iva=" + valor_iva + "]";
	}
	
}
