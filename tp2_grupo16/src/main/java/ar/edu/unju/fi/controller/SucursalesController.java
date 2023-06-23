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

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursales")
public class SucursalesController {
	
	/**
	 * Inyectamos la interfaz del servicio de Sucursal
	 */
	@Autowired
	private ISucursalService sucursalService;
	
	/** Ir a la pagina de Sucursales
	 * @author Yufra Alejandro
	 * @return renderiza el la pag con el listado de sucursales
	 */
    @GetMapping("")
    public String getSucursalesPage() {
        return "redirect:/sucursales/listado";
    }
    
    /** Cargar el listado de las sucursales 
     * @author Yufra Alejandro
     * @param model
     * @return renderiza la pag sucursales
     */
    @GetMapping("/listado")
    public String getListaDeSucursalesPage(Model model) {
    	model.addAttribute("sucursales", sucursalService.listarSucursales());
        return "sucursales";
    }
    
    /** Crear una nueva Sucursal seleccionada
     * @author Yufra Alejandro
     * @param model
     * @return renderiza la pag sucursales y vuelve a cargar la lista de las sucursales
     */
    @GetMapping("/nueva")
    public String getNuevaSucursalPage(Model model) {
        model.addAttribute("edicion", false);
        model.addAttribute("sucursal", sucursalService.getSucursal());
        return "nueva_sucursal";
    }
    
    /** Guardar una nueva Sucursal
     * @author Yufra Alejandro
     * @param sucursal
     * @param model
     * @return renderiza la pag sucursales y vuelve a cargar la lista de las sucursales
     */
    @PostMapping("/guardar")
    public String guardarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("sucursal", sucursal);
        	return "nueva_sucursal";
        } else {               
        	sucursalService.guardarSucursal(sucursal);

	        return "redirect:/sucursales/listado";
        }
    }
    
    /** Modifica una Sucursal de la lista
     * @author Yufra Alejandro
     * @param nombre
     * @param model
     * @return renderiza la pag nueva_sucursal con sus datos que fueron guardados al crearlo
     */
    @GetMapping("/modificar/{nombre}")
    public String modificarSucursal(@PathVariable("nombre")String nombre, Model model) {
    	Sucursal sucursalEncontrada = sucursalService.getBy(nombre);
    	model.addAttribute("edicion", true);
    	model.addAttribute("sucursal", sucursalEncontrada);
    	return "nueva_sucursal";
    }
    
    /** Modifica la Sucursal seleccionada
     * @author Yufra Alejandro
     * @param sucursal
     * @return renderiza la pag sucursales y vuelve a cargar la lista de las sucursales
     */
    @PostMapping("/modificar")
    public String modificarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		model.addAttribute("sucursal", sucursal);
    		model.addAttribute("edicion", true);
	    	return "nueva_sucursal";
    	} else {
	    	sucursalService.modificarSucursal(sucursal);
    		return "redirect:/sucursales/listado";
    	}
    }
    
    /** Eliminar una sucursal de la lista
     * @author Yufra Alejandro
     * @param nombre
     * @return vuelve a renderizar la pag de sucursales y vuelve a cargar la lista de las sucursales
     */
    @GetMapping("/eliminar/{nombre}")
    public String eliminarSucursal(@PathVariable("nombre")String nombre) {
    	sucursalService.eliminarSucursal(nombre);
    	return "redirect:/sucursales/listado";
    }
    
}



