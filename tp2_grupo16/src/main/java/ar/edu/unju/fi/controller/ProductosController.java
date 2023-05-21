package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.listas.ListaProductos;

@Controller
public class ProductosController {
	private ListaProductos listaProductos = new ListaProductos();
	
	@GetMapping("/productos")
	public String getProductosPage(Model model) {
		model.addAttribute("productos", listaProductos.getProductos());
		return "productos";
	}
}
