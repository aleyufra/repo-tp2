package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.listas.ListaProductos;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Service
public class ProductoServiceImp implements IProductoService {
	
	/**
	 *  inyectamos las dependencias de la lista de productos y el objeto producto del paquete model
	 */
	
	@Autowired
	private ListaProductos listaProductos;
	@Autowired
	private Producto producto;
	
	
	/**
	 *  implementamos todos los metodos de la interfaz de servicio
	 */
	
	@Override
	public List<Producto> listarProductos() {
		return listaProductos.getProductos();
	}

	@Override
	public void guardarProducto(@Valid Producto producto) {
		producto.setPrecioFinal(producto.getPrecio());
		listaProductos.getProductos().add(producto);
	}

	@Override
	public void modificarProducto(Producto producto) {
		for (Producto prod : listaProductos.getProductos()) {
			if (prod.getCodigo().equals(producto.getCodigo())) {
				prod.setNombre(producto.getNombre());
				prod.setCategoria(producto.getCategoria());
				prod.setImagen(producto.getImagen());
				prod.setPrecio(producto.getPrecio());
				prod.setDescuento(producto.getDescuento());
				prod.setPrecioFinal(producto.getPrecioFinal());
				break;
			}
		}
	}

	
	@Override
	public void eliminarProducto(String codigo) {
		for (Producto prod : listaProductos.getProductos()) {
			if (prod.getCodigo().toString().equals(codigo)) {
				listaProductos.getProductos().remove(prod);
				break;
			}
		}
	}
	
	
	/**
	 * Busca un producto por su código.
	 * @author Alavar Ezequiel
	 * @param codigo El código del producto a buscar.
	 * @return El producto encontrado o null si no se encuentra ningún producto con ese código.
	 */
	@Override
	public Producto getBy(String codigo) {
		Producto productoEncontrado = null;
    	for (Producto prod : listaProductos.getProductos()) {
    		String codigoProducto = String.valueOf(prod.getCodigo()); 
    		if (codigoProducto.equals(codigo)) {
    			productoEncontrado = prod;
    			break;
    		}
    	}
    	return productoEncontrado;
	}

	@Override
	public Producto getProducto() {
		return producto;
	}
	
}
