package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.listas.ListaServicios;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioDePaseosController {
	
	/**
	 * Inyectamos la interfaz del servicio de Servicio
	 */
	@Autowired
	private IServicioService servicioService;
	
	
	/** Controlador para redireccionar a la pag de Servicios
	 * @author Yufra Alejandro
	 * @param model
	 * @return renderiza la pag servicios y recarga su lista
	 */
	@GetMapping("")
	public String goToServiciosPage(Model model) {
		return "redirect:/servicios/listado";
	}
	
	/** Controlador para mostrar la página de lista de servicios de paseos.
	 * @author Yufra Alejandro
	 * @param model
	 * @return renderiza la pag sdpaseos
	 */
	@GetMapping("/listado")
	public String getServicioDePaseosPage(Model model) {
		model.addAttribute("servicios", servicioService.listarServicios());
		return "sdpaseos";
	}
	
	/** Controlador para mostrar la página de nuevo servicio.
	 * @author Yufra Alejandro
	 * @param model
	 * @return renderiza la pag nuevo_servicio
	 */
	@GetMapping("/nuevo")
	public String getListadoDeServiciosPage(Model model) {
		model.addAttribute("edicion", false);
		model.addAttribute("disabled", false);
		model.addAttribute("servicio", servicioService.getServicio());
		return "nuevo_servicio";
	}
	
	/** Controlador para procesar el formulario de nuevo servicio y guardarlo en la lista de servicios. ACTUALIZACIÓN: Se realizo la modificación para utilizar ModelAndView
	 * @author Yufra Alejandro , Karen Gutierrez
	 * @param servicio
	 * @return renderiza la pagina nuevo_servicio en caso de algun error de validacion
	 * @return renderia la pag sdpaseos en caso de que los datos sean validos
	 */
	@PostMapping("/guardar")
	public String getGuardarServicioPage(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result, Model model) {
		model.addAttribute("edicion", false);
		if(result.hasErrors()) {
			model.addAttribute("servicio", servicio);
			return "nuevo_servicio";
		}
		servicioService.guardarServicio(servicio);
        return "redirect:/servicios/listado";
    }
	
	/** Controlador para mostrar la página de modificación de un servicio existente.
	 * @author Yufra Alejandro
	 * @param model
	 * @param nombre
	 * @return renderiza la pag nuevo_serivicio
	 */
	@GetMapping("/modificar/{nombre}")
	public String getModificarServicioPage(@PathVariable("nombre")String nombre, Model model) {
    	Servicio servicioEncontrado = servicioService.getBy(nombre);
    	model.addAttribute("edicion", true);
		model.addAttribute("servicio", servicioEncontrado);
		return "nuevo_servicio";
	}
	
	/** Controlador para procesar la modificación de un servicio existente.
	 * @author Yufra Alejandro
	 * @param servicio
	 * @return renderiza la pag servicios y recarga su listado de servicios
	 */
	@PostMapping("/modificar")
	public String modificarServicio(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("servicio", servicio);
			model.addAttribute("edicion", true);
			return "nuevo_servicio";
		} else {
			servicioService.modificarServicio(servicio);
			return "redirect:/servicios/listado";
		}
	}
	
	/** Controlador para eliminar un servicio
	 * @author Yufra Alejandro
	 * @param nombre
	 * @return renderiza la pag servicios y recarga su listado de servicios
	 */
	@GetMapping("/eliminar/{nombre}")
	public String eliminarServicio(@PathVariable("nombre")String nombre) {
		servicioService.eliminarServicio(nombre);
		return "redirect:/servicios/listado";
	}
	
}



