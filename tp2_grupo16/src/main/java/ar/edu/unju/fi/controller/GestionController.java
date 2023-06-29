package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IConsejoService;
import ar.edu.unju.fi.service.IProductoService;
import ar.edu.unju.fi.service.ISucursalService;

@Controller
@RequestMapping("/gestion")
public class GestionController {

	/*
	 * inyeccion de dependencias
	 */
	
	@Autowired
	private IConsejoService consejoService;
	
	@Autowired
	private ISucursalService sucuService;
	
	@Autowired
	private IProductoService productoService;
	
	/*
	 * cargamos la pagina de gestion con todos los atributos necesarios para e cargado de listas en la pagina
	 */
    @GetMapping("")
    public String getListaDeSucursalesPage(Model model) {
    	model.addAttribute("consejos_de_salud", consejoService.listarConsejos());
    	model.addAttribute("sucursales", sucuService.listarSucursales());
    	model.addAttribute("productos", productoService.listarProductos());
        return "gestion";
    }
    
    
}
