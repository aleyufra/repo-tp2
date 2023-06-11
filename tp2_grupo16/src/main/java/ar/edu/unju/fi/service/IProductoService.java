package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;

public interface IProductoService {
	
	/**
	 *  Clase interfaz del servicio de producto
	 */
	
	/** metodo para obtener la lista de productos
	 * 
	 * @return la lista de productos
	 */
	List<Producto> listarProductos();
	
	/** metodo para guardar un producto y agregarlo a la lista
	 * 
	 * @param producto
	 */
	void guardarProducto(@Valid Producto producto);
	
	/** metodo para modificar un producto de la lista
	 * 
	 * @param producto
	 */
	void modificarProducto(Producto producto);
	
	/** metodo para eliminar un producto de la lista
	 * 
	 * @param codigo de tipo String
	 */
	void eliminarProducto(String codigo);
	
	/** metodo para buscar un producto de a la lista
	 * 
	 * @param codigo
	 * @return el id de tipo String
	 */
	Producto getBy(String codigo);
	
	/** metodo para instanciar un nuevo objeto de clase producto
	 * 
	 * @return el producto instanciado sin valores seteados
	 */
	Producto getProducto();
	
}
