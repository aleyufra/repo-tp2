package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Consejo;
import jakarta.validation.Valid;

//import ar.edu.unju.fi.model.Consejo;

public interface IConsejoService {

	/**
	 *  Clase interfaz del servicio de consejos
	 */
	
	
	/** metodo para obtener la lista de consejos
	 * 
	 * @return la lista de consejos
	 */
	List<Consejo> listarConsejos();

	/** metodo para guardar un consejo y agregarlo a la lista
	 * 
	 * @param consejo a guardar
	 */
	void guardarConsejo(@Valid Consejo consejo);
	
	/** metodo para modificar un consejo de la lista
	 * 
	 * @param consejo a modificar
	 */
	
	void modificarConsejo(Consejo consejo);
	
	/** metodo para eliminar un consejo de la lista
	 * 
	 * @param titulo del consejo
	 */
	
	void eliminarConsejo(String titulo);
	
	/** metodo para buscar un consejo de a la lista
	 * 
	 * @param titulo del consejo
	 * @return el consejo encontrado
	 */
	
	Consejo getBy(String titulo);
	
	/** metodo para instanciar un nuevo objeto de la clase consejo
	 * 
	 * @return el consejo instanciado sin valores seteados
	 */
	
	Consejo getConsejo();
	
}
