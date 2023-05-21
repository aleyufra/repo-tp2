package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductosController {

	/**
	 * Redirecciona a la página "productos"
	 * 
	 * @return La vista de la página "productos"
	 */	
	@GetMapping("/productos")
	public String getProductosPage() {
		return "productos";
	}
}
