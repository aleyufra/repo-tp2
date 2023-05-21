package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

	/**
	 * Redirecciona a la página "index"
	 * 
	 * @return La vista de la página "index"
	 */
	@GetMapping("/index")
	public String getInicioPage() {
		return "index";
	}
}
