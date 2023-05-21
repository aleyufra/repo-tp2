package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {

	/**
	 * Redirecciona a la página "contacto"
	 * 
	 * @return La vista de la página "contacto"
	 */
	@GetMapping("/contacto")
	public String getContactoPage() {
		return "contacto";
	}
}
