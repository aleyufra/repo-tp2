package ar.edu.unju.fi.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cat_id")
	private Long id;
	
	@Column(name="cat_nombre", nullable=false)
	private String nombre;
	
	@ManyToMany(mappedBy = "categorias")
	private List<Producto> productos;
	
	
	@Column(name= "cat_estado", nullable = false)
	private boolean estado;
	
	public Categoria() { }
	
	
	// getter and setter
	
	public Categoria(String nombre) {
		this.nombre = nombre;
	}

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
}
