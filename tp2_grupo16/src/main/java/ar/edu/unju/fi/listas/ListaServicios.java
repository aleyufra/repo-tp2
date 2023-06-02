package ar.edu.unju.fi.listas;
import ar.edu.unju.fi.model.Servicio;
import java.util.List;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ListaServicios {
	
	private List<Servicio> servicios;
	
	public ListaServicios() {
		servicios = new ArrayList<Servicio>();
		servicios.add(new Servicio("María", "Tutú", "Peluqueria", "Jueves"));
		servicios.add(new Servicio("Diego", "Salchicha", "Paseo", "Martes"));
		servicios.add(new Servicio("Juan", "Napoleon", "Baño", "Lunes"));
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
}
