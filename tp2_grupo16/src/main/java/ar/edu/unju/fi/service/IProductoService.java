package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Producto;
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
	
	/** metodo para obtener la lista de categorias
	 * 
	 * @return la lista de categorias
	 */
	List<Categoria> listarCategorias();
	
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
	 * @param id de tipo Long
	 */
	void eliminarProducto(Long id);
	
	/** metodo para buscar un producto de a la lista
	 * 
	 * @param id
	 * @return un producto si lo encuentra
	 */
	Producto findById(Long id);
	
	/** metodo para instanciar un nuevo objeto de clase producto
	 * 
	 * @return el producto instanciado sin valores seteados
	 */
	Producto getProducto();
	
}
