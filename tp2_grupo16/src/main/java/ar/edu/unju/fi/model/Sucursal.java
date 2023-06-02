package ar.edu.unju.fi.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Grupo16
 *
 */
@Component
public class Sucursal {
	
	private String nombre;
	private String direccion;
	private String barrio;
	private String ciudad;
	private String telefono;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaInauguracion;
	
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
	
	public Sucursal(String nombre, String direccion, String barrio, String ciudad, LocalDate fechaInauguracion, String telefono) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.barrio = barrio;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.fechaInauguracion = fechaInauguracion;
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
	
	
}
