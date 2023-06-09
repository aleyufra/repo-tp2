package ar.edu.unju.fi.listas;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Servicio;

import java.util.ArrayList;

@Component
public class ListaServicios {
	
	private List<Servicio> servicios;
	
	public ListaServicios() {
		servicios = new ArrayList<Servicio>();
		servicios.add(new Servicio("Maria", "Tutu", "Peluqueria", "Jueves", "9:00"));
		servicios.add(new Servicio("Diego", "Salchicha", "Paseo", "Martes", "18:00"));
		servicios.add(new Servicio("Juan", "Napoleon", "Baño", "Lunes", "11:00"));
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
}
