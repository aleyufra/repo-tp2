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
	
	// Controlador para redireccionar a la página de mensajes de contacto
	@GetMapping("")
	public String goToContactoPage() {
		enviado = false;
		return "redirect:/contacto/mensaje";
	}
	
	// Controlador para mostrar la página de mensajes de contacto
	@GetMapping("/mensaje")
	public String getContactoPage(Model model) {
		model.addAttribute("enviado", enviado);
		return "contacto";
	}
	
	// Controlador para enviar un mensaje de contacto
	@PostMapping("/enviar")
	public String enviarMensaje(Model model) {
		
		enviado = true;
		model.addAttribute("enviado", enviado);
		return "redirect:/contacto/mensaje";
	}
}
