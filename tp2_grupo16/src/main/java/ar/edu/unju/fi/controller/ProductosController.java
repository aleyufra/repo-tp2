package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.listas.ListaProductos;
import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductosController {
	
	//inyeccion de dependencias
	
	@Autowired
	private ListaProductos listaProductos;
	@Autowired
	private Producto producto, productoEncontrado;
	
	/** Redireccionamiento a pagina de productos
	 * 
	 * @param model
	 * @return renderiza la pagina productos recargando su lista
	 */
	@GetMapping("")
	public String goToProductosPage(Model model) {
		return "redirect:/productos/lista";
	}
	
	
	/** Controlador para mostrar la página de productos
	 * 
	 * @param model
	 * @return la pagina productos
	 */
	@GetMapping("/lista")
	public String getProductosPage(Model model) {
		model.addAttribute("productos", listaProductos.getProductos());
		return "productos";
	}
	
	/** Controlador para mostrar la página de nuevo producto
	 * 
	 * @param model
	 * @return la pagina de nuevo-producto
	 */
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		producto = new Producto();
		model.addAttribute("edicion", false);
		model.addAttribute("producto", producto);
		return "nuevo-producto";
	}
	
	/** Controlador para procesar el envío del formulario de nuevo producto
	 * 
	 * @param producto
	 * @param result
	 * @param model
	 * @return retorn la pagina de nuevo-producto en caso de salir algun error de validacion
	 * @return renderiza la pagina productos y carga su lista en caso de que se haya agregado datos validos
	 */
	@PostMapping("/guardar")
	public String postNuevoProductoPage(@Valid @ModelAttribute("producto")Producto producto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("producto", producto);
			model.addAttribute("edicion", false);
			return "nuevo-producto";
		} else {
			producto.setPrecioFinal(producto.getPrecio());
			listaProductos.getProductos().add(producto);
			model.addAttribute("productos", listaProductos.getProductos());
			return "redirect:/productos/lista";
		}
	}	
	
	/** Controlador para mostrar la página de modificación de un producto específico
	 * 
	 * @param codigo
	 * @param model
	 * @return renderiza la pagina nuevo-producto
	 */
	@GetMapping("/modificar/{codigo}")
	public String getEditarProductoPage(@PathVariable("codigo")String codigo, Model model) {
		Producto prod = this.buscarProducto(codigo);
		productoEncontrado.setNombre(prod.getNombre());
		productoEncontrado.setCategoria(prod.getCategoria());
		productoEncontrado.setCodigo(prod.getCodigo());
		productoEncontrado.setPrecio(prod.getPrecio());
		productoEncontrado.setDescuento(prod.getDescuento());
		model.addAttribute("producto", productoEncontrado);
		model.addAttribute("edicion", true);
		return "nuevo-producto";
		
	}
	
	/** Controlador para procesar la modificación de un producto específico
	 * 
	 * @param producto
	 * @param result
	 * @param model
	 * @return en caso de error de validacion, retorna a la pagina nuevo-producto
	 * @return en caso de que los datos sean validos, redirecciona a la pagina productos y recarga su lista
	 */
	@PostMapping("/modificar")
	public String modificarProducto(@Valid @ModelAttribute("producto")Producto producto, BindingResult result, Model model) {
		producto.setCodigo(productoEncontrado.getCodigo());
		if (result.hasFieldErrors("nombre") || result.hasFieldErrors("categoria") ||
			result.hasFieldErrors("precio") || result.hasFieldErrors("descuento")) {
			model.addAttribute("edicion", true);
			model.addAttribute("producto", producto);
			return "nuevo-producto";
		} else {
			for (Producto prod : listaProductos.getProductos()) {
				if (prod.getCodigo() == productoEncontrado.getCodigo()) {
					prod.setNombre(producto.getNombre());
					prod.setCategoria(producto.getCategoria());
					prod.setPrecio(producto.getPrecio());
					prod.setDescuento(producto.getDescuento());
					prod.setPrecioFinal(producto.getPrecioFinal());
					break;
				}
			}
			return "redirect:/productos/lista";
		}
	}
	
	/** Controlador para eliminar un producto específico
	 * 
	 * @param codigo
	 * @return redirecciona a la pagina productos y recarga su lista
	 */
	@GetMapping("/eliminar/{codigo}")
	public String deleteProductoPage(@PathVariable("codigo")String codigo) {
    	Producto productoABorrar = this.buscarProducto(codigo);
    	listaProductos.getProductos().remove(productoABorrar);
    	return "redirect:/productos/lista";
	}
	
	/**
	 * Busca un producto por su código.
	 * 
	 * @param codigo El código del producto a buscar.
	 * @return El producto encontrado o null si no se encuentra ningún producto con ese código.
	 */
	private Producto buscarProducto(String codigo) {
		Producto productoBuscado = null;
    	for (Producto prod : listaProductos.getProductos()) {
    		String codigoProducto = String.valueOf(prod.getCodigo()); 
    		if (codigoProducto.equals(codigo)) {
    			//System.out.println(codigoProducto);
    			//System.out.println(prod.getCodigo());
    			productoBuscado = prod;
    			break;
    		}
    	}
    	return productoBuscado;
	}
}
