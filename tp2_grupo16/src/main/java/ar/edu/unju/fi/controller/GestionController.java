package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.ISucursalService;

@Controller
@RequestMapping("/gestion")
public class GestionController {

	@Autowired
	@Qualifier("sucursalServiceMysqlImp")
	private ISucursalService sucuService;
	
    @GetMapping("")
    public String getListaDeSucursalesPage(Model model) {
    	model.addAttribute("sucursales", sucuService.listarSucursales());
        return "gestion";
    }
    
    
}
