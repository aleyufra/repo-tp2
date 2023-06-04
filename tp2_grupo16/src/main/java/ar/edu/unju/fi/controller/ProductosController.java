package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.controller.form.FormProducto;
import ar.edu.unju.fi.listas.ListaProductos;
import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;

@Controller
public class ProductosController {
	private ListaProductos listaProductos = new ListaProductos();
	
	@Autowired
	private FormProducto miFormulario;

	// Controlador para mostrar la página de productos
	@GetMapping("/productos")
	public String getProductosPage(Model model) {
		model.addAttribute("productos", listaProductos.getProductos());
		return "productos";
	}
	
	// Controlador para mostrar la página de nuevo producto
	@GetMapping("/productos/nuevo")
	public String getNuevoProductoPage(Model model) {
		miFormulario = new FormProducto();
		model.addAttribute("formProducto", miFormulario);
		return "nuevo-producto";
	}
	
	// Controlador para procesar el envío del formulario de nuevo producto
	@PostMapping("/productos")
	public ModelAndView postNuevoProductoPage(@Valid FormProducto formProducto, BindingResult result) {
		ModelAndView modelView = new ModelAndView("productos");
		if(result.hasErrors()) {
			modelView.setViewName("nuevo-producto");
			modelView.addObject("formProducto", formProducto);
			return modelView;
		}
			
		Producto nuevoProducto = new Producto(formProducto.getNombre(),formProducto.getCategoria(), formProducto.getCodigo(), formProducto.getPrecio(), formProducto.getDescuento());
		
		listaProductos.getProductos().add(nuevoProducto);
		modelView.addObject("productos", listaProductos.getProductos());
		return modelView;
	}
	
	// Controlador para mostrar la página de modificación de un producto específico
	@GetMapping("/productos/editar/{codigo}")
	public String getEditarProductoPage(@PathVariable(value="codigo")String codigo, Model model) {
		Producto prod = this.buscarProducto(codigo);
		miFormulario.setNombre(prod.getNombre());
		miFormulario.setCategoria(prod.getCategoria());
		miFormulario.setCodigo(prod.getCodigo());
		miFormulario.setPrecio(prod.getPrecio());
		miFormulario.setDescuento(prod.getDescuento());
		
		model.addAttribute("formProducto", miFormulario);
		return "nuevo-producto";
		
	}
	
	// Controlador para procesar la modificación de un producto específico
	@PostMapping("/productos/{codigo}")
	public String postNuevoProductoPage(@PathVariable(value="codigo")String codigo, FormProducto formProducto) {
		Producto producto = this.buscarProducto(codigo);
		
		producto.setNombre(formProducto.getNombre());
		producto.setCategoria(formProducto.getCategoria());
		producto.setPrecio(formProducto.getPrecio());
		producto.setDescuento(formProducto.getDescuento());
		producto.setPrecioFinal(producto.calcularDescuento());
		return "redirect:/productos";
	}
	
	// Controlador para eliminar un producto específico
	@GetMapping("/productos/eliminar/{codigo}")
	public String deleteProductoPage(@PathVariable(value="codigo")String codigo) {
    	Producto producto = this.buscarProducto(codigo);
    	listaProductos.getProductos().remove(producto);
    	
    	return "redirect:/productos";
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
    			productoBuscado = prod;
    			break;
    		}
    	}
    	return productoBuscado;
	}
}
