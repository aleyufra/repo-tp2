package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * 
 * @author Grupo16
 *
 */
@Component
@Entity
@Table(name="servicios")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serv_id")
	private Long serv_id;
	
	@Column(name = "serv_nombre_dueño", nullable = false)
	@Size(min=3, max=32, message="el nombre del dueño debe contener 3-32 caracteres.")
	@Pattern(regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras.")
	private String nombre;
	
	@Column(name = "serv_nombre_mascota", nullable = false)
	@NotEmpty(message="El campo de nombre no puede estar vacio.")
	@Size(min=3, max=32, message="el nombre de la mascota debe contener 4-32 caracteres.")
	@Pattern(regexp= "[a-z A-Z]*", message="Solo puede ingresar letras. (sin tildes y Ñ)")
	private String nombreMascota;
	
	@Column(name = "serv_tipo", nullable = false)
	@NotBlank(message="Debe seleccionar un servicio")
	private String servicio;
	
	@Column(name = "serv_dia", nullable = false)
	@NotBlank(message="Debe seleccionar un día")
	private String dia;
	
	@Column(name = "serv_hora", nullable = false)
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
