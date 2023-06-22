package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

/**
 * 
 * @author Grupo16
 *
 */
@Component
public class Producto {
	
	@NotEmpty(message="El campo de nombre no puede estar vacio.")
	@Size(min=3, max=32, message="el nombre del producto debe contener 4-32 caracteres.")
	@Pattern(regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras.")
	private String nombre;
	
	@NotBlank(message="Debe seleccionar una de las opciones.")
	private String categoria;
	

	@NotNull(message = "El campo de codigo no puede estar vacío")
	@Min(value=1000, message="Debe ingresar un codigo de 4 digitos.")
	@Max(value=9999, message="Debe ingresar un codigo de 4 digitos.")
	private Integer codigo;
	
	@NotNull(message = "El campo de precio no puede estar vacío")
	@DecimalMin(value="1.0", message="El precio deber ser minimo $1.00.")
	@DecimalMax(value="999999.9", message="El precio debe ser menor a un millon.")
	private Double precio;
	
	@NotNull(message = "El campo de descuento no puede estar vacío")
	@PositiveOrZero(message = "el descuento debe ser un valor positivo.")
	@Max(value = 50, message = "El maximo descuento es 50%.")
	private Byte descuento;
	
	private double precioFinal;
	
	// Constructor por defecto
	public Producto() { }
	
	/** Constructor de Producto
	 * 
	 * @param nombre del producto
	 * @param categoria del producto
	 * @param codigo del producto
	 * @param precio del producto
	 * @param descuento del producto, entero entre [1, 50]
	 */
	public Producto(String nombre, String categoria, Integer codigo, Double precio, Byte descuento) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.codigo = codigo;
		this.precio = (Double) precio;
		this.descuento = (Byte) descuento;
		this.precioFinal = this.calcularPrecioConDescuento((Byte) this.descuento);
	}
	
	// getters and setters
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
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Byte getDescuento() {
		return descuento;
	}
	public void setDescuento(Byte descuento) {
		this.descuento = descuento;
	}
	
	public double getPrecioFinal() {
		return precioFinal;
	}
	
	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = this.calcularPrecioConDescuento((Byte) this.descuento);
	}
	
	
	/** Metodo que calcula el descuento aplicado al precio del producto.
	 * 
	 * @return El precio final con descuento
	 */
	public double calcularPrecioConDescuento(Byte descuento) {
		return this.precioFinal = this.precio - (this.precio * ((double)descuento/100));
	}
}
