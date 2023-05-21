package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicioDePaseosController {

	/**
	 * Redirecciona a la página "sdpaseos"
	 * 
	 * @return La vista de la página "sdpaseos"
	 */
	@GetMapping("/sdpaseos")
	public String getServicioDePaseosController() {
		return "sdpaseos";
	}
}
