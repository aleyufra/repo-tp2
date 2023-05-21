package ar.edu.unju.fi.controller.form;

public class FormProducto {
	private String nombre;
	private String categoria;
	private int codigo;
	private double precio;
	private byte descuento;
	
	public FormProducto() {
		// TODO Auto-generated constructor stub
	}
	
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
