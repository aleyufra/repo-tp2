package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaServicios;
import ar.edu.unju.fi.model.Servicio;

@Controller
@RequestMapping("/servicios")
public class ServicioDePaseosController {
	
	ListaServicios listaServicios = new ListaServicios();
	boolean edicion = false;
	Servicio servicioEncontrado;

	@GetMapping("/listado")
	public String getServicioDePaseosPage(Model model) {
		model.addAttribute("servicios", listaServicios.getServicios());
		return "sdpaseos";
	}
	
	@GetMapping("/nuevo")
	public String getListadoDeServiciosPage(Model model) {
		edicion = false;
		model.addAttribute("edicion", edicion);
		boolean disabled = false;
		model.addAttribute("disabled", disabled);
		model.addAttribute("servicio", new Servicio());
		return "nuevo_servicio";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarServiciopage(@ModelAttribute("servicio")Servicio servicio) {
		ModelAndView modelView = new ModelAndView("sdpaseos");
		listaServicios.getServicios().add(servicio);
		modelView.addObject("servicios", listaServicios.getServicios());
		return modelView;
	}
	
	@GetMapping("/modificar/{nombre}")
	public String getModificarServicioPage(Model model, @PathVariable(value="nombre")String nombre) {
		servicioEncontrado = null;
		edicion = true;
		model.addAttribute("edicion", edicion);
		boolean disabled = true;
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
	
	@PostMapping("/modificar")
	public String modificarServicio(@ModelAttribute("servicio")Servicio servicio) {
		for (Servicio servi : listaServicios.getServicios()) {
			if (servi.getNombre().equals(servicioEncontrado.getNombre())) {
				servi.setNombreMascota(servicio.getNombreMascota());
		        servi.setServicio(servicio.getServicio());
		        servi.setDia(servicio.getDia());
		        break;
			}
		}
		return "redirect:/servicios/listado";
	}
	
	@GetMapping("/eliminar/{nombre}")
	public String eliminarServicio(@PathVariable(value="nombre")String nombre) {
		for (Servicio servi : listaServicios.getServicios()) {
			if (servi.getNombre().equals(nombre)) {
				listaServicios.getServicios().remove(servi);
				break;
			}
		}
		return "redirect:/servicios/listado";
	}
}



