package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;
import jakarta.validation.Valid;

public interface ISucursalService {
	
	/**
	 *  Clase interfaz del servicio de sucursales
	 */
	
	
	/** metodo para obtener la lista de sucursales
	 * 
	 * @return la lista de sucursales
	 */
	List<Sucursal> listarSucursales();
	
	
	/** metodo para guardar una sucursal y agregarlo a la lista
	 * 
	 * @param sucursal a guardar
	 */
	void guardarSucursal(@Valid Sucursal sucursal);
	
	
	/** metodo para modificar una sucursal de la lista
	 * 
	 * @param sucursal a modificar
	 */
	void modificarSucursal(Sucursal sucursal);
	
	
	/** metodo para eliminar una sucursal de la lista
	 * 
	 * @param nombre de la sucursal
	 */
	void eliminarSucursal(String nombre);
	
	
	/** metodo para buscar una sucursal de a la lista
	 * 
	 * @param nombre de la sucursal
	 * @return la sucursal encontrado
	 */
	Sucursal getBy(String nombre);
	
	
	/** metodo para instanciar un nuevo objeto de la clase sucursal
	 * 
	 * @return la sucursal instanciada sin valores seteados
	 */
	Sucursal getSucursal();

}
