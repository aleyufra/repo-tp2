package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Consejo;
import jakarta.validation.Valid;

/**
 *  Clase interfaz del servicio de consejos
 */
public interface IConsejoService {

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
	
	void eliminarConsejo(Long id);
	
	/** metodo para buscar un consejo de a la lista
	 * 
	 * @param titulo del consejo
	 * @return el consejo encontrado
	 */
	
	Consejo getBy(Long id);
	
	/** metodo para instanciar un nuevo objeto de la clase consejo
	 * 
	 * @return el consejo instanciado sin valores seteados
	 */
	
	Consejo getConsejo();
	
}
