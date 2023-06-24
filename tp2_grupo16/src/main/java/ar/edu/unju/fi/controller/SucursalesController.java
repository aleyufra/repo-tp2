package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.IProvinciaService;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursales")
public class SucursalesController {
	
	/**
	 * Inyectamos la interfaz del servicio de Sucursal
	 */
	@Autowired
	@Qualifier("sucursalServiceMysqlImp")
	private ISucursalService sucursalService;
	
	@Autowired
	@Qualifier("provinciaServiceImp")
	private IProvinciaService provinciaService;
	
	Long ide;
	
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
    	List<Provincia> provincias = provinciaService.getProvincias();
    	Sucursal nuevaSucursal = sucursalService.getSucursal();
    	nuevaSucursal.setProvincia(new Provincia()); // Asignar una instancia vacía de Provincia
        model.addAttribute("edicion", false);
        model.addAttribute("sucursal", sucursalService.getSucursal());
        model.addAttribute("provincias", provincias);
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
    	if (sucursal.getProvincia().getId() == null) {
    		sucursal.setProvincia(null);
            result.rejectValue("provincia", "error.provincia", "Debe seleccionar una provincia");
    	}
    	if (result.hasErrors()) {
        	model.addAttribute("sucursal", sucursal);
        	model.addAttribute("provincias", provinciaService.getProvincias());
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
    @GetMapping("/modificar/{id}")
    public String modificarSucursal(@PathVariable("id")Long id, Model model) {
    	Sucursal sucursalEncontrada = sucursalService.getById(id);
    	ide = sucursalEncontrada.getId();
    	model.addAttribute("edicion", true);
    	model.addAttribute("sucursal", sucursalEncontrada);
    	model.addAttribute("provincias", provinciaService.getProvincias());
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
    		model.addAttribute("provincias", provinciaService.getProvincias());
    		model.addAttribute("edicion", true);
	    	return "nueva_sucursal";
    	} else {
    		sucursal.setId(ide);
	    	sucursalService.modificarSucursal(sucursal);
    		return "redirect:/sucursales/listado";
    	}
    }
    
    /** Eliminar una sucursal de la lista
     * @author Yufra Alejandro
     * @param nombre
     * @return vuelve a renderizar la pag de sucursales y vuelve a cargar la lista de las sucursales
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarSucursal(@PathVariable("id")Long id) {
    	sucursalService.eliminarSucursal(id);
    	return "redirect:/sucursales/listado";
    }
    
}



