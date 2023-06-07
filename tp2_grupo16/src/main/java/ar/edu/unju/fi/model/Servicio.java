package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * 
 * @author Grupo16
 *
 */
@Component
public class Servicio {
	
	
	@Size(min=3, max=32, message="el nombre del dueño debe contener 3-32 caracteres.")
	@Pattern(regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras.")
	private String nombre;
	
	@NotEmpty(message="El campo de nombre no puede estar vacio.")
	@Size(min=3, max=32, message="el nombre de la mascota debe contener 4-32 caracteres.")
	@Pattern(regexp= "[a-z A-Z]*", message="Solo puede ingresar caracteres alfanumericos.")
	private String nombreMascota;
	
	@NotBlank(message="Debe seleccionar un servicio")
	private String servicio;
	
	@NotBlank(message="Debe seleccionar un día")
	private String dia;
	
	@NotBlank(message="Debe seleccionar un horario")
	private String hora;
	
	public Servicio() {}

	/** Crea una nueva instancia de la clase Servicio
	 * 
	 * @param nombre El nombre del dueño de la mascota
	 * @param nombreMascota El nombre de la mascota
	 * @param servicio El nombre del servicio a realizar
	 * @param dia El dia a realizar el servicio
	 */
	public Servicio(String nombre, String nombreMascota, String servicio, String dia, String hora) {
		this.nombre = nombre;
		this.nombreMascota = nombreMascota;
		this.servicio = servicio;
		this.dia = dia;
		this.hora = hora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	
	public String getHora() {
		return hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
}
