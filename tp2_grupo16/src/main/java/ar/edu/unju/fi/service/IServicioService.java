package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Servicio;
import jakarta.validation.Valid;

public interface IServicioService {
	
	/**
	 *  Clase interfaz del servicio de servicios
	 */
	
	
	/** metodo para obtener la lista de servicios
	 * 
	 * @return la lista de productos
	 */
	List<Servicio> listarServicios();
	
	
	/** metodo para guardar un servicio y agregarlo a la lista
	 * 
	 * @param servicio de tipo Servicio
	 */
	void guardarServicio(@Valid Servicio servicio);
	
	
	/** metodo para modificar un servicio de la lista
	 * 
	 * @param servicio de tipo Servicio
	 */
	void modificarServicio(Servicio servicio);
	
	
	/** metodo para eliminar un servicio de la lista
	 * 
	 * @param nombre del dueño de tipo String
	 */
	void eliminarServicio(String nombre);
	
	
	/** metodo para buscar un servicio de a la lista
	 * 
	 * @param nombre del dueño de tipo String
	 * @return el nombre del servicio encontrado
	 */
	Servicio getBy(String nombre);
	
	
	/** metodo para instanciar un nuevo objeto de clase servicio
	 * 
	 * @return el servicio instanciado sin valores seteados
	 */
	Servicio getServicio();

}
