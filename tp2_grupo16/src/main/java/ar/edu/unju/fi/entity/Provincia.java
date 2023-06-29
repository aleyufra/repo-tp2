package ar.edu.unju.fi.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "provincias")
public class Provincia {
	
	/* MAPEO DE LA CLASE PROVINCIA */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "provincia_id")
	private Long id;
	
	@Column(name = "provincia_nombre")
	private String nombre;
	
	/* Relacion uno a muchos 
	   se vincula con el atributo de provincia de la clase Sucursal */
	@OneToMany(mappedBy = "provincia")
    private List<Sucursal> sucursales;

	// Constructor vacío (necesario para JPA)
    public Provincia() {
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

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	
	
}
