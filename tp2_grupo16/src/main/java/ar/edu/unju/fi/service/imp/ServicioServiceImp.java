package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaServicios;
import ar.edu.unju.fi.model.Servicio;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Service
public class ServicioServiceImp implements IServicioService {
	
	/**
	 *  inyectamos las dependencias de la lista de servicios y el objeto Servicio del paquete model
	 */
	
	@Autowired
	private ListaServicios listaServicios;
	
	@Autowired
	private Servicio servicio;
	
	/**
	 *  implementamos todos los metodos de la interfaz de servicio
	 */
	
	@Override
	public List<Servicio> listarServicios() {
		return listaServicios.getServicios();
	}

	@Override
	public void guardarServicio(@Valid Servicio servicio) {
		servicio.setNombre(nombreFormat(servicio.getNombre()));
		servicio.setNombreMascota(nombreFormat(servicio.getNombreMascota()));
		listaServicios.getServicios().add(servicio);
	}

	@Override
	public void modificarServicio(Servicio servicio) {
		for (Servicio servi : listaServicios.getServicios()) {
			if (servi.getNombre().equals(servicio.getNombre())) {
				servi.setNombreMascota(nombreFormat(servicio.getNombreMascota()));
		        servi.setServicio(servicio.getServicio());
		        servi.setDia(servicio.getDia());
		        servi.setHora(servicio.getHora());
		        break;
			}
		}
	}

	@Override
	public void eliminarServicio(String nombre) {
		for (Servicio servi : listaServicios.getServicios()) {
			if (servi.getNombre().equals(nombre)) {
				listaServicios.getServicios().remove(servi);
				break;
			}
		}
	}

	@Override
	public Servicio getBy(String nombre) {
		Servicio servicioEncontrado = null;
		for (Servicio servi: listaServicios.getServicios()) {
			if (servi.getNombre().equals(nombre)) {
				servicioEncontrado = servi;
				break;
			}
		}
		return servicioEncontrado;
	}

	@Override
	public Servicio getServicio() {
		return servicio;
	}
	
	/** Convertir Primera Letra en Mayuscula
     * @author Yufra Alejandro
     * @param palabra
     * @return la palabra ingresada como argumento pero con la primera letra en mayuscula
     */
    public String nombreFormat(String palabra) {
    	return palabra.substring(0,1).toUpperCase() + palabra.substring(1).toLowerCase();
    }
	
}
