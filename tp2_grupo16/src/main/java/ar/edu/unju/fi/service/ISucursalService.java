package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Sucursal;
import jakarta.validation.Valid;

public interface ISucursalService {
	
	List<Sucursal> listarSucursales();
	
	void guardarSucursal(@Valid Sucursal sucursal);
	
	void modificarSucursal(Sucursal sucursal);
	
	void eliminarSucursal(Sucursal sucursal);
	
	Sucursal getBy(String nombre);
	
	Sucursal getSucursal();

}
