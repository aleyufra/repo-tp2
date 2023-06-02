package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.listas.ListaSucursales;
import ar.edu.unju.fi.model.Sucursal;

@Controller
@RequestMapping("/sucursales")
public class SucursalesController {
	
	@Autowired
    private ListaSucursales listaSucursales;
	@Autowired
    private Sucursal sucursal, sucursalEncontrada;
	
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
        model.addAttribute("sucursales", listaSucursales.getSucursales());
        return "sucursales";
    }
    
    /** Crear una nueva Sucursal seleccionada
     * @author Yufra Alejandro
     * @param model
     * @return renderiza la pag sucursales y vuelve a cargar la lista de las sucursales
     */
    @GetMapping("/nueva")
    public String getNuevaSucursalPage(Model model) {
        boolean edicion = false;
        model.addAttribute("edicion", edicion);
        model.addAttribute("sucursal", sucursal);
        return "nueva_sucursal";
    }
    
    /** Guardar una nueva Sucursal
     * @author Yufra Alejandro
     * @param sucursal
     * @param model
     * @return renderiza la pag sucursales y vuelve a cargar la lista de las sucursales
     */
    @PostMapping("/guardar")
    public String guardarSucursal(@ModelAttribute("sucursal")Sucursal sucursal, Model model) {
        sucursal.setNombre(nombreFormat(sucursal.getNombre()));
        sucursal.setDireccion(nombreFormat(sucursal.getDireccion()));
        sucursal.setBarrio(nombreFormat(sucursal.getBarrio()));
        
        if (sucursal.getEstadoStr().equals("Abierto")) {
        	sucursal.setEstado(true);
        } else if (sucursal.getEstadoStr().equals("Cerrado")) {
        	sucursal.setEstado(false);
        }                
        listaSucursales.getSucursales().add(sucursal);
        model.addAttribute("sucursales", listaSucursales.getSucursales());
        return "redirect:/sucursales/listado";
        //listaSucursales.getSucursales().isEmpty()
    }
    
    /** Modifica una Sucursal de la lista
     * @author Yufra Alejandro
     * @param nombre
     * @param model
     * @return renderiza la pag nueva_sucursal con sus datos que fueron guardados al crearlo
     */
    @GetMapping("/modificar/{nombre}")
    public String modificarSucursal(@PathVariable("nombre")String nombre, Model model) {
    	sucursalEncontrada = new Sucursal();
    	boolean edicion = true;
    	boolean disabled = true;
    	model.addAttribute("edicion", edicion);
    	model.addAttribute("disabled", disabled);
    	for (Sucursal sucu : listaSucursales.getSucursales()) {
    		if (sucu.getNombre().equals(nombre)) {
    			sucursalEncontrada.setNombre(sucu.getNombre());
    			sucursalEncontrada.setDireccion(sucu.getDireccion());
    			sucursalEncontrada.setBarrio(sucu.getBarrio());
    			sucursalEncontrada.setCiudad(sucu.getCiudad());
    			sucursalEncontrada.setFechaInauguracion(sucu.getFechaInauguracion());
    			sucursalEncontrada.setTelefono(sucu.getTelefono());
    			sucursalEncontrada.setImagen(sucu.getImagen());
    			sucursalEncontrada.setEstadoStr(sucu.getEstadoStr());
    			sucursalEncontrada.setEstado(sucu.getEstado());
    		}
    	}
    	model.addAttribute("sucursal", sucursalEncontrada);
    	return "nueva_sucursal";
    }
    
    /** Modifica la Sucursal seleccionada
     * @author Yufra Alejandro
     * @param sucursal
     * @return renderiza la pag sucursales y vuelve a cargar la lista de las sucursales
     */
    @PostMapping("/modificar")
    public String modificarSucursal(@ModelAttribute("sucursal")Sucursal sucursal, Model model) {
    	for (Sucursal sucu : listaSucursales.getSucursales()) {
    		if (sucu.getNombre().equals(sucursalEncontrada.getNombre())) {
    			sucu.setDireccion( nombreFormat(sucursal.getDireccion()));
    			sucu.setBarrio( nombreFormat(sucursal.getBarrio()));
    			sucu.setCiudad(sucursal.getCiudad());
    			sucu.setFechaInauguracion(sucursal.getFechaInauguracion());
    			sucu.setTelefono(sucursal.getTelefono());
    			sucu.setImagen(sucursal.getImagen());
    			
    			sucu.setEstadoStr(sucursal.getEstadoStr());
    			if (sucu.getEstadoStr().equals("Abierto")) {
    				sucu.setEstado(true);
    			} else if (sucu.getEstadoStr().equals("Cerrado")) {
    				sucu.setEstado(false);
    			}
    			System.out.println(sucu.getEstadoStr());
    			System.out.println(sucu.getEstado());
    			break;
    		}
    	}
    	return "redirect:/sucursales/listado";
    }
    
    /** Eliminar una sucursal de la lista
     * @author Yufra Alejandro
     * @param nombre
     * @return vuelve a renderizar la pag de sucursales y vuelve a cargar la lista de las sucursales
     */
    @GetMapping("/eliminar/{nombre}")
    public String eliminarSucursal(@PathVariable("nombre")String nombre) {
    	for (Sucursal sucu : listaSucursales.getSucursales()) {
    		if (sucu.getNombre().equals(nombre)) {
    			listaSucursales.getSucursales().remove(sucu);
    			break;
    		}
    	}
    	return "redirect:/sucursales/listado";
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



