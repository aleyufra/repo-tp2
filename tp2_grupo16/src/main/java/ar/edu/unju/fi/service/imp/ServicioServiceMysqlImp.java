package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.repository.IServicioRepository;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Service("servicioServiceMysql")
public class ServicioServiceMysqlImp implements IServicioService {
	
	@Autowired
	private IServicioRepository servicioRepository;
	
	@Autowired
	private Servicio servicio;

	@Override
	public List<Servicio> listarServicios() {
		// retornamos aquellos servicios cuyo estados esten es TRUE
		return servicioRepository.findByEstado(true);
	}

	/** 
	 * Método para guardar servicio
	 */
	@Override
	public void guardarServicio(@Valid Servicio servicio) {
		servicioRepository.save(servicio);

	}
	
	/**
	 * Método para modificar servicio
	 */

	@Override
	public void modificarServicio(Servicio servicio) {
		servicioRepository.save(servicio);
	}

	@Override
	public void eliminarServicio(Long id) {
		servicioRepository.save(servicio);
	}

	@Override
	public Servicio getById(Long id) {
		return servicioRepository.findById(id).get();
	}

	@Override
	public Servicio getServicio() {
		return servicio;
	}

}
