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
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaServicios;
import ar.edu.unju.fi.model.Servicio;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioDePaseosController {
	
	@Autowired
	ListaServicios listaServicios;
	@Autowired
	Servicio servicio, servicioEncontrado;
	
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
		model.addAttribute("servicios", listaServicios.getServicios());
		return "sdpaseos";
	}
	
	/** Controlador para mostrar la página de nuevo servicio.
	 * @author Yufra Alejandro
	 * @param model
	 * @return renderiza la pag nuevo_servicio
	 */
	@GetMapping("/nuevo")
	public String getListadoDeServiciosPage(Model model) {
		boolean edicion = false;
		boolean disabled = false;
		model.addAttribute("edicion", edicion);
		model.addAttribute("disabled", disabled);
		model.addAttribute("servicio", servicio);
		
		return "nuevo_servicio";
	}
	
	/** Controlador para procesar el formulario de nuevo servicio y guardarlo en la lista de servicios. ACTUALIZACIÓN: Se realizo la modificación para utilizar ModelAndView
	 * @author Yufra Alejandro , Karen Gutierrez
	 * @param servicio
	 * @return renderia la pag sdpaseos
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarServicioPage(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result) {
    	ModelAndView modelView = new ModelAndView("servicio");
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_servicio");
			modelView.addObject("servicio",servicio);
			return modelView;
		}
		listaServicios.getServicios().add(servicio);
        modelView.addObject("servicio", listaServicios.getServicios());
        return modelView;
    }
	
	/** Controlador para mostrar la página de modificación de un servicio existente.
	 * @author Yufra Alejandro
	 * @param model
	 * @param nombre
	 * @return renderiza la pag nuevo_serivicio
	 */
	@GetMapping("/modificar/{nombre}")
	public String getModificarServicioPage(@PathVariable("nombre")String nombre, Model model) {
		boolean edicion = true;
		boolean disabled = true;
		model.addAttribute("edicion", edicion);
		model.addAttribute("disabled", disabled);
		for (Servicio servi: listaServicios.getServicios()) {
			if (servi.getNombre().equals(nombre)) {
				servicioEncontrado = servi;
				break;
			}
		}

		model.addAttribute("servicio", servicioEncontrado);
		return "nuevo_servicio";
	}
	
	/** Controlador para procesar la modificación de un servicio existente.
	 * @author Yufra Alejandro
	 * @param servicio
	 * @return renderiza la pag servicios y recarga su listado de servicios
	 */
	@PostMapping("/modificar")
	public String modificarServicio(@ModelAttribute("servicio")Servicio servicio) {
		for (Servicio servi : listaServicios.getServicios()) {
			if (servi.getNombre().equals(servicioEncontrado.getNombre())) {
				servi.setNombreMascota(nombreFormat(servicio.getNombreMascota()));
		        servi.setServicio(servicio.getServicio());
		        servi.setDia(servicio.getDia());
		        servi.setHora(servicio.getHora());
		        break;
			}
		}
		return "redirect:/servicios/listado";
	}
	
	/** Controlador para eliminar un servicio
	 * @author Yufra Alejandro
	 * @param nombre
	 * @return renderiza la pag servicios y recarga su listado de servicios
	 */
	@GetMapping("/eliminar/{nombre}")
	public String eliminarServicio(@PathVariable("nombre")String nombre) {
		for (Servicio servi : listaServicios.getServicios()) {
			if (servi.getNombre().equals(nombre)) {
				listaServicios.getServicios().remove(servi);
				break;
			}
		}
		return "redirect:/servicios/listado";
	}
	
	/** Convertir Primera Letra en Mayuscula
     * @author Yufra Alejandro
     * @param palabra
     * @return la palabra ingresada como argumento pero con la primera letra en mayuscula
     */
    public String nombreFormat(String palabra) {
    	return palabra.substring(0,1).toUpperCase() + palabra.substring(1).toLowerCase();
    }
	
}



