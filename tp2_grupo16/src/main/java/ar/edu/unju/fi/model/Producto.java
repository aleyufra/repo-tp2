package ar.edu.unju.fi.model;

/**
 * 
 * @author Grupo16
 *
 */

public class Producto {

	String nombre, categoria;
	int codigo;
	double precio, precioFinal;
	byte descuento;
	
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
	
	public double getPrecioFinal() {
		return precioFinal;
	}
	
	/**
	 * 
	 * @param nombre del producto
	 * @param categoria del producto
	 * @param codigo del producto
	 * @param precio del producto
	 * @param descuento del producto, entero entre [1, 50]
	 */
	
	public Producto(String nombre, String categoria, int codigo, double precio, byte descuento) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.codigo = codigo;
		this.precio = precio;
		this.descuento = descuento;
		this.precioFinal = this.calcularDescuento();
	}
	
	/**
	 * Metodo que calcula el descuento aplicado al precio del producto.
	 * @return El precio con descuento.
	 */
	
	public double calcularDescuento() {
	
		double precioConDescuento = this.precio;
	
		if(this.descuento > 0 && this.descuento <= 50) {
			
			precioConDescuento = this.precio * (float)this.descuento / 100;
		}
		return precioConDescuento;
	}
}
