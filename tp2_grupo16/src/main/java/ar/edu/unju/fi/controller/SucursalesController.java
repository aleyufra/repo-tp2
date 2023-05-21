package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SucursalesController {

	/**
	 * Redirecciona a la página "sucursales"
	 * 
	 * @return La vista de la página "sucursales"
	 */	
	@GetMapping("/sucursales")
	public String getSucursalesPage() {
		return "sucursales";
	}
}
