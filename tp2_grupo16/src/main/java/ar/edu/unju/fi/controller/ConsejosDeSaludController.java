package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsejosDeSaludController {

	@GetMapping("/consejos_de_salud")
	public String getConsejosDeSaludPage() {
		return "consejos_de_salud";
	}
}
