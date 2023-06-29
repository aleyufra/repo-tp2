package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Provincia;

public interface IProvinciaService {
	
	/*
	 * obtener todas las provincias de la bd
	 */
	List<Provincia> getProvincias();
	
	/**
	 * metodo para guardar una provincia en la bd
	 * @param provincia de tipo Provincia
	 */
	void saveProvincia(Provincia provincia);
	
	/**
	 * obtener una instancia del objeto Provincia
	 * @return objeto Provincia
	 */
	Provincia getProvincia();
}
