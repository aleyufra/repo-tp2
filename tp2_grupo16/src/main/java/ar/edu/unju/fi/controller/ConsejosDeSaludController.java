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

import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejos_de_salud")
public class ConsejosDeSaludController {
	
	@Autowired
	private IConsejoService consejoService;
	

	/**
	 * Redirecciona a la página "consejos_de_salud"
	 * 
	 * @return La vista de la página "consejos_de_salud"
	 */
	@GetMapping("")
	public String getConsejosDeSaludPage() {
		return "redirect:/consejos_de_salud/listado";
	}
	
	/** Cargar el listado de los consejos de salud
     * @author Gutierrez Karen
     * @param model
     * @return renderiza la pag de consejos de salud
     */
    @GetMapping("/listado")
    public String getListaDeConsejosPage(Model model) {
    	model.addAttribute("consejos_de_salud", consejoService.listarConsejos());
        return "consejos_de_salud";
    }
    
    /** Crear un nuevo Consejo de Salud
     * @author Gutierrez Karen
     * @param model
     * @return renderiza la pag consejos y vuelve a cargar la lista de los consejos
     */
    @GetMapping("/nuevo")
    public String getNuevoConsejoPage(Model model) {
        model.addAttribute("edicion", false);
        model.addAttribute("consejo", consejoService.getConsejo());
        return "nuevo_consejo";
    }
    
    /** Guardar un nuevo Consejo de Salud
     * @author Gutierrez Karen
     * @param consejo
     * @param model
     * @return renderiza la pag consejos y vuelve a cargar la lista de los consejos de salud
     */
    @PostMapping("/guardar")
    public String guardarConsejo(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("consejo", consejo);
        	model.addAttribute("edicion", false);
        	return "nuevo_consejo";
        } else {  
        	consejoService.guardarConsejo(consejo);
	        return "redirect:/consejos_de_salud/listado";
        }
    }
    
    /** Modifica un consejo de la lista
     * @author Gutierrez Karen
     * @param titulo
     * @param model
     * @return renderiza la pag nuevo_consejo con sus datos que fueron guardados al crearlo
     */
    @GetMapping("/modificar/{titulo}")
    public String modificarConsejo(@PathVariable("titulo")String titulo, Model model) {
    	Consejo consejoEncontrado = consejoService.getBy(titulo);
    	model.addAttribute("edicion", true);
    	model.addAttribute("consejo", consejoEncontrado);
    	return "nuevo_consejo";
    }
    
    /** Modifica el consejo seleccionado
     * @author Gutierrez Karen
     * @param consejo
     * @return renderiza la pag consejo y vuelve a cargar el listado de los consejos
     */
    @PostMapping("/modificar")
    public String modificarConsejo(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		model.addAttribute("consejo", consejo);
    		model.addAttribute("edicion", true);
	    	return "nuevo_consejo";
    	} else {
    		consejoService.modificarConsejo(consejo);
    		return "redirect:/consejos_de_salud/listado";
    	}
    }
    
    /** Eliminar un consejo de la lista
     * @author Gutierrez Karen
     * @param nombre
     * @return vuelve a renderizar la pag de consejos y vuelve a cargar el listado de los consejos
     */
    @GetMapping("/eliminar/{titulo}")
    public String eliminarConsejo(@PathVariable("titulo")String titulo) {
    	consejoService.eliminarConsejo(titulo);
    	return "redirect:/consejos_de_salud/listado";
    }
}
