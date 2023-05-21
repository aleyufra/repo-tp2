package ar.edu.unju.fi.model;

/**
 * 
 * @author Grupo16
 *
 */
public class Servicio {
	
	private String nombre;
	private String nombreMascota;
	private String servicio;
	private String dia;
	
	public Servicio() {}

	/**
	 * Crea una nueva instancia de la clase Servicio
	 * 
	 * @param nombre El nombre del dueño de la mascota
	 * @param nombreMascota El nombre de la mascota
	 * @param servicio El nombre del servicio a realizar
	 * @param dia El dia a realizar el servicio
	 */
	
	public Servicio(String nombre, String nombreMascota, String servicio, String dia) {
		super();
		this.nombre = nombre;
		this.nombreMascota = nombreMascota;
		this.servicio = servicio;
		this.dia = dia;
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
	
	
}
