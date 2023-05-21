package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacto")
public class ContactoController {
	
	boolean enviado = false;
	
	@GetMapping("")
	public String goToContactoPage() {
		enviado = false;
		return "redirect:/contacto/mensaje";
	}
	
	@GetMapping("/mensaje")
	public String getContactoPage(Model model) {
		model.addAttribute("enviado", enviado);
		return "contacto";
	}
	
	@PostMapping("/enviar")
	public String enviarMensaje(Model model) {
		
		enviado = true;
		model.addAttribute("enviado", enviado);
		return "redirect:/contacto/mensaje";
	}
}
