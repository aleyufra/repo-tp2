package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.listas.ListaConsejos;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Service
public class ConsejoServiceImp implements IConsejoService{
	
	/**
	 *  inyectamos las dependencias de la lista de sucursales y el objeto Sucursal del paquete model
	 */
	
	@Autowired
	private ListaConsejos listaConsejos;
	@Autowired
	private Consejo consejo;
	
	@Override
	public List<Consejo> listarConsejos(){
		return listaConsejos.getConsejos();
	}
	
	/**
	 *  implementamos todos los metodos de la interfaz de servicio
	 */
	
	@Override
	public void guardarConsejo(@Valid Consejo consejo) {
		consejo.setTitulo(nombreFormat(consejo.getTitulo()));
		consejo.setCategoria(nombreFormat(consejo.getCategoria()));
		consejo.setTexto(nombreFormat(consejo.getTexto()));

		listaConsejos.getConsejos().add(consejo);
	}

	@Override
	public void modificarConsejo(Consejo consejo) {
		for (Consejo conse : listaConsejos.getConsejos()) {
    		if (conse.getTitulo().equals(consejo.getTitulo())) {
    			conse.setCategoria(consejo.getCategoria());
    			conse.setTexto( nombreFormat(consejo.getTexto()));
    			break;
    		}
		}
		
	}

	@Override
	public void eliminarConsejo(String titulo) {
		for (Consejo conse : listaConsejos.getConsejos()) {
    		if (conse.getTitulo().equals(titulo)) {
    			listaConsejos.getConsejos().remove(conse);
    			break;
    		}
    	}
	}

	@Override
	public Consejo getBy(String titulo) {
		Consejo consejoEncontrado = null;
		for (Consejo conse : listaConsejos.getConsejos()) {
			if (conse.getTitulo().equals(titulo)) {
				consejoEncontrado = conse;
				break;
			}
		}
		return consejoEncontrado;
	}

	@Override
	public Consejo getConsejo() {
		return consejo;
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
