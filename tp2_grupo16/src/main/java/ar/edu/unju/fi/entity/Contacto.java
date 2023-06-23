package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
public class Contacto {
	
	@Size(min = 3, max = 16, message = "el nombre debe contener 3-16 caracteres.")
	private String nombre;
	
	@NotBlank(message = "el campo email no debe estar vacio.")
	@Email()
	private String email;
	
	@NotEmpty(message = "debe ingresar un mensaje.")
	private String mensaje;
	
	public Contacto() { }
	
	public Contacto(String nombre, String email, String mensaje) {
		this.nombre = nombre;
		this.email = email;
		this.mensaje = mensaje;
	}
	
	// getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
