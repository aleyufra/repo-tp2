package ar.edu.unju.fi.service.imp;

import java.util.List;

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
	
	@Override
	public List<Producto> listarProductos() {
		return productoRepository.findByEstado(true);
	}
	
	@Override
	public List<Categoria> listarCategorias() {
		return categoriaRepository.findByEstado(true);
	}

	@Override
	public void guardarProducto(@Valid Producto producto) {
		producto.setPrecioFinal(producto.getPrecio());
		producto.setEstado(true);
		productoRepository.save(producto);
	}

	@Override
	public void modificarProducto(Producto producto) {
		productoRepository.save(producto);
	}

	
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

	@Override
	public Producto getProducto() {
		return producto;
	}
	
}
