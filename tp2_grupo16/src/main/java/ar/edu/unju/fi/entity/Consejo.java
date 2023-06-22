package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
public class Consejo {
	
	@Size(min=3, max=32, message="el titulo del consejo debe contener 3-32 caracteres.")
	private String titulo;
	
	@NotBlank(message="Debe seleccionar una categoria")
	private String categoria;
	
	@NotEmpty(message="El campo de texto no puede estar vacio.")
	private String texto;
	
	public Consejo() {}

	public Consejo(String titulo, String categoria, String texto) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.texto = texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}