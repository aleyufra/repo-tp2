package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsejosDeSaludController {

	/**
	 * Redirecciona a la página "consejos_de_salud"
	 * 
	 * @return La vista de la página "consejos_de_salud"
	 */
	@GetMapping("/consejos_de_salud")
	public String getConsejosDeSaludPage() {
		return "consejos_de_salud";
	}
}
