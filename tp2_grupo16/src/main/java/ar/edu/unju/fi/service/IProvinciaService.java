package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Provincia;

public interface IProvinciaService {
	
	List<Provincia> getProvincias();
	
	void saveProvincia(Provincia provincia);
	
	Provincia getProvincia();
}
