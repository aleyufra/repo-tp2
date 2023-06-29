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
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "consejos")
public class Consejo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "con_titulo", nullable = false)
	@Size(min=3, max=32, message="el titulo del consejo debe contener 3-32 caracteres.")
	private String titulo;
	
	@Column(name = "con_categoria", nullable = false)
	@NotBlank(message="Debe seleccionar una categoria")
	private String categoria;
	
	@Column(name = "con_texto", nullable = false, length = 512)
	@NotEmpty(message="El campo de texto no puede estar vacio.")
	private String texto;
	
	public Consejo() {}

	public Consejo(Long id, String titulo, String categoria, String texto) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.texto = texto;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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