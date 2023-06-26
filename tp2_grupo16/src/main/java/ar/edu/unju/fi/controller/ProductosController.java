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

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductosController {
	
	/**
	 * Inyectamos la interfaz del servicio de Producto
	 */
	
	@Autowired
	private IProductoService productoService;
	
	
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
		model.addAttribute("productos", productoService.listarProductos());
		return "productos";
	}
	
	/** Controlador para mostrar la página de nuevo producto
	 * 
	 * @param model
	 * @return la pagina de nuevo-producto
	 */
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		model.addAttribute("edicion", false);
		model.addAttribute("producto", productoService.getProducto());
		model.addAttribute("categorias", productoService.listarCategorias());
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
			model.addAttribute("categorias", productoService.listarCategorias());
			return "nuevo-producto";
		} else {
			productoService.guardarProducto(producto);
			return "redirect:/productos/lista";
		}
	}	
	
	/** Controlador para mostrar la página de modificación de un producto específico
	 * 
	 * @param id
	 * @param model
	 * @return renderiza la pagina nuevo-producto
	 */
	@GetMapping("/modificar/{id}")
	public String getEditarProductoPage(@PathVariable("id")Long id, Model model) {
	    Producto productoEncontrado = productoService.findById(id);
		model.addAttribute("producto", productoEncontrado);
		model.addAttribute("edicion", true);
		model.addAttribute("categorias", productoService.listarCategorias());
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
		if (result.hasErrors()) {
			model.addAttribute("edicion", true);
			model.addAttribute("producto", producto);
			model.addAttribute("categorias", productoService.listarCategorias());
			return "nuevo-producto";
		} else {
			productoService.modificarProducto(producto);
			return "redirect:/productos/lista";
		}
	}
	
	/** Controlador para eliminar un producto específico
	 * 
	 * @param id
	 * @return redirecciona a la pagina productos y recarga su lista
	 */
	@GetMapping("/eliminar/{id}")
	public String deleteProductoPage(@PathVariable("id")Long id) {
    	productoService.eliminarProducto(id);
    	return "redirect:/productos/lista";
	}
	
}
