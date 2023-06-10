package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;

public interface IProductoService {
	
	List<Producto> listarProductos();
	
	void guardarProducto(@Valid Producto producto);
	
	void modificarProducto(Producto producto);
	
	void eliminarProducto(Producto productoBuscado);
	
	Producto getBy(int codigo);
	
	Producto getProducto();
	
}
