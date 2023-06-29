package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.ICategoriaRepository;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Service("productoServiceMysql")
public class ProductoServiceMysqlImp implements IProductoService{
	/**
	 *  inyectamos las dependencias de la lista de productos y el objeto producto del paquete model
	 */
	
	@Autowired
	private IProductoRepository productoRepository;
	@Autowired
	private ICategoriaRepository categoriaRepository;
	@Autowired
	private Producto producto;
	
	
	/**
	 *  implementamos todos los metodos de la interfaz de servicio
	 */
	
	/**
	 * devolvemos un listado de los productos con estado true
	 */
	@Override
	public List<Producto> listarProductos() {
		return productoRepository.findByEstado(true);
	}
	

	/*
	 * guardamos un producto con el metodo save y asignandole su estado a true
	 */
	@Override
	public void guardarProducto(@Valid Producto producto) {
		producto.setPrecioFinal(producto.getPrecio());
		producto.setEstado(true);
		productoRepository.save(producto);
	}

	/*
	 * modificamos un producto de la base de datos con el metodo save
	 */
	@Override
	public void modificarProducto(Producto producto) {
		productoRepository.save(producto);
	}

	
	/**
	 * hacemos una eliminacion logica asignando al estado en false
	 */
	@Override
	public void eliminarProducto(Long id) {
		producto = productoRepository.findById(id).get();
		producto.setEstado(false);
		productoRepository.save(producto);
	}
	
	
	/**
	 * Busca un producto por su código.
	 * @author Alavar Ezequiel
	 * @param codigo El código del producto a buscar.
	 * @return El producto encontrado o null si no se encuentra ningún producto con ese código.
	 */
	@Override
	public Producto findById(Long id) {
		return productoRepository.findById(id).get();
	}
	
	/*
	 * obtenemos una nueva instancia del objeto Producto
	 */
	@Override
	public Producto getProducto() {
		return producto;
	}
	
	/**
	 * metodo para obtener un listado de productos por su categoria
	 * creamos un objeto List de Producto en donde guardamos todos los productos y otro vacio
	 * con un for iteramos aquellos productos que coincidan con la categoria pasada por parametro
	 */
	public List<Producto> getProductosPorCategoria(String categoria){
		List<Producto> allproductos = (List<Producto>) productoRepository.findAll();
		List<Producto> productos = new ArrayList<Producto>();
		for(Producto prod : allproductos) {
			if(prod.getCategorias().getNombre().equals(categoria)) {
				productos.add(prod);
			}
		}
		return productos;
	}
}
