package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaSucursales;
import ar.edu.unju.fi.model.Servicio;
import ar.edu.unju.fi.model.Sucursal;

@Controller
@RequestMapping("/sucursales")
public class SucursalesController {

    private ListaSucursales listaSucursales = new ListaSucursales();
    private boolean edicion = false;
    private Sucursal sucursalEncontrada;

    @GetMapping("")
    public String getSucursalesPage() {
        return "redirect:/sucursales/listado";
    }

    @GetMapping("/listado")
    public String getListaDeSucursalesPage(Model model) {
        model.addAttribute("sucursales", listaSucursales.getSucursales());
        return "sucursales";
    }

    @GetMapping("/nueva")
    public String getNuevaSucursalPage(Model model) {
        edicion = false;
        model.addAttribute("edicion", edicion);
        model.addAttribute("sucursal", new Sucursal());
        return "nueva_sucursal";
    }

    @PostMapping("/guardar")
    public String guardarSucursal(@ModelAttribute("sucursal")Sucursal sucursal, Model model) {
        listaSucursales.getSucursales().add(sucursal);
        model.addAttribute("sucursales", listaSucursales.getSucursales());
        return "sucursales";
    }
    
    @GetMapping("/modificar/{nombre}")
    public String modificarSucursal(@PathVariable(value="nombre")String nombre, Model model) {
    	sucursalEncontrada = new Sucursal();
    	edicion = true;
    	boolean disabled = true;
    	model.addAttribute("edicion",edicion);
    	model.addAttribute("disabled",disabled);
    	for (Sucursal sucu : listaSucursales.getSucursales()) {
    		if (sucu.getNombre().equals(nombre)) {
    			sucursalEncontrada.setNombre(sucu.getNombre());
    			sucursalEncontrada.setDireccion(sucu.getDireccion());
    			sucursalEncontrada.setBarrio(sucu.getBarrio());
    			sucursalEncontrada.setCiudad(sucu.getCiudad());
    			sucursalEncontrada.setFechaInauguracion(sucu.getFechaInauguracion());
    			sucursalEncontrada.setTelefono(sucu.getTelefono());
    		}
    	}
    	model.addAttribute("sucursal",sucursalEncontrada);
    	return "nueva_sucursal";
    }
    
    @PostMapping("/modificar")
    public String modificarSucursal(@ModelAttribute("sucursal")Sucursal sucursal) {
    	for (Sucursal sucu : listaSucursales.getSucursales()) {
    		if (sucu.getNombre().equals(sucursalEncontrada.getNombre())) {
    			sucu.setDireccion(sucursal.getDireccion());
    			sucu.setBarrio(sucursal.getBarrio());
    			sucu.setCiudad(sucursal.getCiudad());
    			sucu.setFechaInauguracion(sucursal.getFechaInauguracion());
    			sucu.setTelefono(sucursal.getTelefono());
    			break;
    		}
    	}
    	return "redirect:/sucursales/listado";
    }
    
    @GetMapping("/eliminar/{nombre}")
    public String eliminarSucursal(@PathVariable(value="nombre")String nombre) {
    	for (Sucursal sucu : listaSucursales.getSucursales()) {
    		if (sucu.getNombre().equals(nombre)) {
    			listaSucursales.getSucursales().remove(sucu);
    			break;
    		}
    	}
    	return "redirect:/sucursales/listado";
    }
}



