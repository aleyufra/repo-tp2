package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.listas.ListaMensajes;
import ar.edu.unju.fi.model.Contacto;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/contacto")
public class ContactoController {
	
	@Autowired
	public ListaMensajes mensajes;
	@Autowired
	public Contacto contacto;
	
	/** Controlador para redireccionar a la página de mensajes de contacto
	 * 
	 * @return redirecciona a la pagina de contacto
	 */
	@GetMapping("")
	public String goToContactoPage() {
		return "redirect:/contacto/mensaje";
	}
	
	/** Controlador para mostrar la página de mensajes de contacto
	 * 
	 * @param model
	 * @return renderiza la pagina contacto
	 */
	@GetMapping("/mensaje")
	public String getContactoPage(Model model) {
		contacto = new Contacto();
		model.addAttribute("contacto", contacto);
		model.addAttribute("mensajes", mensajes.getMensajes());
		return "contacto";
	}
	
	/** Controlador para enviar un mensaje de contacto
	 * 
	 * @param contacto
	 * @param result
	 * @param model
	 * @return en caso de algun error de validacion, retorna a la pagina contacto
	 * @return en caso de que los datos sean validos, redirecciona a la pagina contacto
	 */
	@PostMapping("/enviar") 
	public String enviarMensaje(@Valid @ModelAttribute("contacto")Contacto contacto, BindingResult result,  Model model) {
		if (result.hasErrors()) {
			model.addAttribute("enviado", false);
			model.addAttribute("contacto", contacto);
			model.addAttribute("mensajes", mensajes.getMensajes());
			return "contacto";
		} else { 
			mensajes.getMensajes().add(contacto);
			model.addAttribute("enviado", true);
			model.addAttribute("mensajes", mensajes);
			return "redirect:/contacto/mensaje";
		}
	}
}
