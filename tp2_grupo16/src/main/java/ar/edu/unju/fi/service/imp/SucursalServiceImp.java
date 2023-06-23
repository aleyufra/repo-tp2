package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.listas.ListaSucursales;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Service
public class SucursalServiceImp implements ISucursalService{
	
	/**
	 *  inyectamos las dependencias de la lista de sucursales y el objeto Sucursal del paquete model
	 */
	
	@Autowired
	private ListaSucursales listaSucursales;
	@Autowired
	private Sucursal sucursal;
	
	@Override
	public List<Sucursal> listarSucursales() {
		return listaSucursales.getSucursales();
	}
	
	/**
	 *  implementamos todos los metodos de la interfaz de servicio
	 */
	
	@Override
	public void guardarSucursal(@Valid Sucursal sucursal) {
		sucursal.setNombre(nombreFormat(sucursal.getNombre()));
		sucursal.setDireccion(nombreFormat(sucursal.getDireccion()));
		sucursal.setBarrio(nombreFormat(sucursal.getBarrio()));
		if (sucursal.getEstadoStr().equals("Abierto")) {
			sucursal.setEstado(true);
		} else if (sucursal.getEstadoStr().equals("Cerrado")) {
			sucursal.setEstado(false);
		}
		listaSucursales.getSucursales().add(sucursal);
	}

	@Override
	public void modificarSucursal(Sucursal sucursal) {
		for (Sucursal sucu : listaSucursales.getSucursales()) {
    		if (sucu.getNombre().equals(sucursal.getNombre())) {
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
    			break;
    		}
		}
		
	}

	@Override
	public void eliminarSucursal(String nombre) {
		for (Sucursal sucu : listaSucursales.getSucursales()) {
    		if (sucu.getNombre().equals(nombre)) {
    			listaSucursales.getSucursales().remove(sucu);
    			break;
    		}
    	}
	}

	@Override
	public Sucursal getBy(String nombre) {
		Sucursal sucursalEncontrada = null;
		for (Sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getNombre().equals(nombre)) {
				sucursalEncontrada = sucu;
				break;
			}
		}
		return sucursalEncontrada;
	}

	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}
	
	
	/** Convertir Primera Letra en Mayuscula y el resto en Minuscula
     * @author Yufra Alejandro
     * @param palabra
     * @return la palabra ingresada como argumento pero con la primera letra en mayuscula
     */
    public String nombreFormat(String palabra) {
    	return palabra.substring(0,1).toUpperCase() + palabra.substring(1).toLowerCase();
    }
}
