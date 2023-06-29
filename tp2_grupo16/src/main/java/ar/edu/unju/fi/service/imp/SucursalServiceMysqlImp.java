package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Service("sucursalServiceMysqlImp")
public class SucursalServiceMysqlImp implements ISucursalService {

	/* inyeccion de dependencias */
	
	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private Sucursal sucursal;
	
	@Override
	public List<Sucursal> listarSucursales() {
		// retornamos aquellas sucursales cuyo estados esten es TRUE
		return sucursalRepository.findByEstado(true);
	}
	
	/*  Metodo para guardar sucursal
	 * 
	 *  dependiendo si el usuario selecciono 'Abierto' o 'Cerrado' esta quedara en 'estadoStr'
	 *  se seteara el valor a TRUE o FALSE a su atributo logico 'estado'
	 *  lo guardamos en la base de datos utilizando el metodo save de CrudRepository 
	 */
	@Override
	public void guardarSucursal(@Valid Sucursal sucursal) {
		if (sucursal.getEstadoStr().equals("Abierto")) {
			sucursal.setEstado(true);
			sucursal.setEstadoStr("Abierto");
		} else if (sucursal.getEstadoStr().equals("Cerrado")) {
			sucursal.setEstado(false);
			sucursal.setEstadoStr("Cerrado");
		} 
		sucursalRepository.save(sucursal);
	}
	
	
	/* Metodo para modificar los valores de una sucursal
	 * 
	 * dependiendo si el usuario selecciono 'Abierto' o 'Cerrado' esta quedara en 'estadoStr'
	 * se seteara el valor a TRUE o FALSE a su atributo logico 'estado'
	 * al tener un id proporcionado por la BD el metodo save de CrudRepository guarda los cambios realizados 
	 */
	@Override
	public void modificarSucursal(Sucursal sucursal) {
		if (sucursal.getEstadoStr().equals("Abierto")) {
			sucursal.setEstado(true);
			sucursal.setEstadoStr("Abierto");
		} else if (sucursal.getEstadoStr().equals("Cerrado")) {
			sucursal.setEstado(false);
			sucursal.setEstadoStr("Cerrado");
		}
		sucursalRepository.save(sucursal);
	}

	@Override
	public void eliminarSucursal(Long id) {
		// realizamos una eliminacion logica
		Sucursal sucu = sucursalRepository.findById(id).get();
		sucu.setEstado(false);
		sucu.setEstadoStr("Cerrado");
		sucursalRepository.save(sucu);
	}


	@Override
	public Sucursal getById(Long id) {
		//obtenemos una sucursal especifica dependiendo de su ID
		return sucursalRepository.findById(id).get();
	}

	@Override
	public Sucursal getSucursal() {
		// retorna una nueva instancia de Sucursal
		return sucursal;
	}
	
	/* Metodo para filtrar sucursales entre dos fechas
	 * 
	 * obtenemos primero todas las sucursales
	 * creamos una variable de tipo ArrayList donde guardaremos las sucursales filtradas
	 * recorremos la lista de todas las sucursales y usando metodos de fechas vamos
	 * agregando las sucursales que cumplan con la condicion
	 * retornamos el ArrayList
	 */
	@Override
	public List<Sucursal> getSucursalesByFecha(LocalDate fechaInicio, LocalDate fechaFin) {
	    List<Sucursal> todasSucursales = (List<Sucursal>) sucursalRepository.findAll();
	    List<Sucursal> sucursalesFiltradas = new ArrayList<Sucursal>();
	    for (Sucursal sucursal : todasSucursales) {
	        LocalDate fechaInauguracion = sucursal.getFechaInauguracion();
	        if (fechaInauguracion.isAfter(fechaInicio) && fechaInauguracion.isBefore(fechaFin)) {
	            sucursalesFiltradas.add(sucursal);
	        }
	    }
	    return sucursalesFiltradas;
	}

}
