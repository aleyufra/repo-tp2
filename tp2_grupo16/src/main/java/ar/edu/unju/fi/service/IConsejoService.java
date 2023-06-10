package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Consejo;

public interface IConsejoService {

	List<Consejo> listarConsejos();
	
	void guardarConsejo(Consejo consejo);
	
	void modificarConsejo(Consejo consejo);
	
	void eliminarConsejo(Consejo consejo);
	
	Consejo getBy();
	
	Consejo getConsejo();
	
}
