package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * 
 * @author Grupo16
 *
 */
@Component
@Entity
@Table(name = "sucursales")
public class Sucursal {
	
	/* MAPEO DE LA CLASE SUCURSAL */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sucu_id")
	private Long id;
	
	@NotEmpty(message="El campo de nombre no puede estar vacio.")
	@Column(name = "sucu_nombre", nullable = false)
	@Size(min= 4 , max = 32, message="el nombre del producto debe contener 4-32 caracteres.")
	@Pattern(regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras.")
	private String nombre;
	
	@Column(name = "sucu_direccion", nullable = false)
	@NotBlank(message = "Debe seleccionar una de las opciones.")
	private String direccion;
	
	@Column(name = "sucu_barrio", nullable = false)
	@NotBlank(message = "El campo no puede estar vacio.")
	@Pattern(regexp = "[a-z A-Z]*", message="No debe ingresar caracteres numericos.")
	private String barrio;
	
	@Column(name = "sucu_ciudad", nullable = false)
	@NotBlank(message = "El campo no puede estar vacio.")
	private String ciudad;
	
	@Column(name = "sucu_telefono", nullable = false)
	@Pattern(regexp = "[0-9][0-9][0-9]+-+[0-9][0-9][0-9][0-9][0-9][0-9][0-9]", 
			 message = "ingrese un num de telefono valido. (Ej: (388-1234567)")
	private String telefono;
	
	@Column(name = "sucu_fechaInauguracion", nullable = false)
	@NotNull(message = "Debe asignar una fecha")
	@PastOrPresent(message = "La fecha no puede ser posterior al actual")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaInauguracion;
	
	@Column(name = "sucu_imagen", nullable = false)
	@NotBlank(message = "Ingrese un URL válido")
	private String imagen;
	
	@Column(name = "sucu_estadoStr", nullable = false)
	@NotBlank(message = "Debe seleccionar una de las opciones.")
	private String estadoStr;
	
	@Column(name = "sucu_estado", nullable = false)
	private boolean estado;
	
	/* Relacion muchos a uno */
	@ManyToOne
	@JoinColumn(name = "prov_id")
	private Provincia provincia;
	
	public Sucursal() {}
	
	/**
	 * Crea una nueva instancia de la clase Sucursal
	 * 
	 * @param nombre El nombre de la sucursal
	 * @param direccion La dirección de la sucursal
	 * @param barrio El barrio donde se encuentra la sucursal
	 * @param ciudad La ciudad donde se encuentra la sucursal
	 * @param fechaInauguracion La fecha de inauguración de la sucursal
	 * @param telefono El telefono de la sucursal
	 */
	public Sucursal(Long id, String nombre, String direccion, String barrio, String ciudad, LocalDate fechaInauguracion, 
			String telefono, String imagen, String estadoStr, boolean estado, Provincia provincia) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.barrio = barrio;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.fechaInauguracion = fechaInauguracion;
		this.imagen = imagen;
		this.estadoStr = estadoStr;
		this.estado = estado;
		this.provincia = provincia;
	}

	// getters and setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaInauguracion() {
		return fechaInauguracion;
	}

	/**
	 * Establece la fecha de inauguración
	 * 
	 * @param fechaInauguracion es la fecha de inauguración a establecer
	 */
	public void setFechaInauguracion(LocalDate fechaInauguracion) {
		this.fechaInauguracion = fechaInauguracion;
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String getEstadoStr() {
		return estadoStr;
	}

	public void setEstadoStr(String estadoStr) {
		this.estadoStr = estadoStr;
	}
	
	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	
}
