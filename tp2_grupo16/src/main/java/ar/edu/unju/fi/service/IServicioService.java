package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Servicio;
import jakarta.validation.Valid;

public interface IServicioService {

	List<Servicio> listarServicios();
	
	void guardarServicio(@Valid Servicio servicio);
	
	void modificarServicio(Servicio servicio);
	
	void eliminarServicio(Servicio servicio);
	
	Servicio getBy(String servicio);
	
	Servicio getServicio();
}
