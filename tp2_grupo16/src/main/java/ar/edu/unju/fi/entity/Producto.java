package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prod_id")
	private Long id;
	
	@NotEmpty(message="El campo de nombre no puede estar vacio.")
	@Size(min=3, max=32, message="el nombre del producto debe contener 4-32 caracteres.")
	@Pattern(regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras.")
	@Column(name="prod_nombre", nullable=false)
	private String nombre;
	
    @ManyToOne
    @JoinColumn(name="cat_id", nullable=false)
    private Categoria categoria;

	@NotNull(message = "El campo de codigo no puede estar vacío")
	@Min(value=1000, message="Debe ingresar un codigo de 4 digitos.")
	@Max(value=9999, message="Debe ingresar un codigo de 4 digitos.")
	@Column(name="prod_codigo", nullable=false)
	private Integer codigo;
	
	@NotBlank(message = "Ingrese un URL válido")
	@Column(name="prod_imagen", nullable=false)
	private String imagen;
	
	@NotNull(message = "El campo de precio no puede estar vacío")
	@DecimalMin(value="1.0", message="El precio deber ser minimo $1.00.")
	@DecimalMax(value="999999.9", message="El precio debe ser menor a un millon.")
	@Column(name="prod_precio", nullable=false)
	private Double precio;
	
	@NotNull(message = "El campo de descuento no puede estar vacío")
	@PositiveOrZero(message = "el descuento debe ser un valor positivo.")
	@Max(value = 50, message = "El maximo descuento es 50%.")
	@Column(name="prod_descuento", nullable=false)
	private Byte descuento;
	
	@Column(name="prod_precio_final", nullable=false)
	private double precioFinal;
	
	@Column(name= "prod_estado", nullable = false)
	private boolean estado;
	
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
	public Producto(String nombre, Categoria categoria, Integer codigo, String imagen, Double precio, Byte descuento) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.codigo = codigo;
		this.imagen = imagen;
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
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
	public boolean getEstado() {
		return this.estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/** Metodo que calcula el descuento aplicado al precio del producto.
	 * 
	 * @return El precio final con descuento
	 */
	public double calcularPrecioConDescuento(Byte descuento) {
		return this.precioFinal = this.precio - (this.precio * ((double)descuento/100));
	}
}
