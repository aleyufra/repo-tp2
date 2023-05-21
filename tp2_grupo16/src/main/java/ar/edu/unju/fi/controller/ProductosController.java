package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String postNuevoProductoPage(Model model, FormProducto formProducto) {
		Producto nuevoProducto = new Producto(formProducto.getNombre(),formProducto.getCategoria(), formProducto.getCodigo(), formProducto.getPrecio(), formProducto.getDescuento());
		
		listaProductos.getProductos().add(nuevoProducto);
		model.addAttribute("productos", listaProductos.getProductos());
		return "productos";
	}
}
