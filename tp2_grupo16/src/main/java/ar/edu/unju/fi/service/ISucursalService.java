package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;
import jakarta.validation.Valid;

/**
 *  Clase interfaz del servicio de sucursales
 */
public interface ISucursalService {
	
	/** metodo para obtener la lista de sucursales
	 * 
	 * @return la lista de sucursales
	 */
	List<Sucursal> listarSucursales();
	
	
	/** metodo para guardar una sucursal y agregarlo a la lista
	 * 
	 * @param sucursal de tipo Sucursal
	 */
	void guardarSucursal(@Valid Sucursal sucursal);
	
	
	/** metodo para modificar una sucursal de la lista
	 * 
	 * @param sucursal de tipo Sucursal
	 */
	void modificarSucursal(Sucursal sucursal);
	
	
	/** metodo para eliminar una sucursal de la lista
	 * 
	 * @param id de la sucursal
	 */
	void eliminarSucursal(Long id);
	
	
	/** metodo para buscar una sucursal de a la lista
	 * 
	 * @param id de la sucursal
	 * @return la sucursal encontrado
	 */
	Sucursal getById(Long id);
	
		
	/** metodo para instanciar un nuevo objeto de la clase sucursal
	 * 
	 * @return la sucursal instanciada sin valores seteados
	 */
	Sucursal getSucursal();

}
