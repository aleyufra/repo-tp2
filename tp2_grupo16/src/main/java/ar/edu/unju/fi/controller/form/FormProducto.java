package ar.edu.unju.fi.controller.form;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Component
public class FormProducto {
	@NotBlank(message="El nombre no puede estar vacio")
	private String nombre;
	
	@NotBlank(message="Debe elegir una categoria")
	private String categoria;
	
	@Min(value=1000, message="El codigo tiene que ser minimo 1000")
	@Max(value=9999, message="El codigo tiene que ser maximo 9999")
	private int codigo;
	
	@Positive(message="El precio debe ser mayor a 0")
	private double precio;
	private byte descuento;
	
	public FormProducto() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param nombre El nombre del producto.
	 * @param categoria La categoría del producto.
	 * @param codigo El código del producto.
	 * @param precio El precio del producto.
	 * @param descuento El descuento aplicado al producto.
	 */
	public FormProducto(String nombre, String categoria, int codigo, double precio, byte descuento) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.codigo = codigo;
		this.precio = precio;
		this.descuento = descuento;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public byte getDescuento() {
		return descuento;
	}
	public void setDescuento(byte descuento) {
		this.descuento = descuento;
	}
}
