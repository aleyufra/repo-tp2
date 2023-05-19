package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicioDePaseosController {

	@GetMapping("/sdpaseos")
	public String getServicioDePaseosController() {
		return "sdpaseos";
	}
}
