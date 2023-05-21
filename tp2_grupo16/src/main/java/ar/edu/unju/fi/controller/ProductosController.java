package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.controller.form.FormProducto;
import ar.edu.unju.fi.listas.ListaProductos;
import ar.edu.unju.fi.model.Producto;

@Controller
public class ProductosController {
	private ListaProductos listaProductos = new ListaProductos();

	@GetMapping("/productos")
	public String getProductosPage(Model model) {
		model.addAttribute("productos", listaProductos.getProductos());
		return "productos";
	}
	
	@GetMapping("/productos/nuevo")
	public String getNuevoProductoPage(Model model) {
		FormProducto miFormulario = new FormProducto();
		model.addAttribute("formProducto", miFormulario);
		return "nuevo-producto";
	}
	
	@PostMapping("/productos")
	public String postNuevoProductoPage(FormProducto formProducto) {
		Producto nuevoProducto = new Producto(formProducto.getNombre(),formProducto.getCategoria(), formProducto.getCodigo(), formProducto.getPrecio(), formProducto.getDescuento());
		
		listaProductos.getProductos().add(nuevoProducto);
		return "redirect:/productos";
	}
	
	@GetMapping("/productos/editar/{codigo}")
	public String getEditarProductoPage(@PathVariable(value="codigo")String codigo, Model model) {
		Producto prod = this.buscarProducto(codigo);
		FormProducto miFormulario = new FormProducto(prod.getNombre(), prod.getCategoria(), prod.getCodigo(), prod.getPrecio(), (byte)prod.getDescuento());
		model.addAttribute("formProducto", miFormulario);
		return "nuevo-producto";
		
	}
	
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
	
	@GetMapping("/productos/eliminar/{codigo}")
	public String deleteProductoPage(@PathVariable(value="codigo")String codigo) {
    	Producto producto = this.buscarProducto(codigo);
    	listaProductos.getProductos().remove(producto);
    	
    	return "redirect:/productos";
	}
	
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
