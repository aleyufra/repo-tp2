package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.repository.IProvinciaRepository;
import ar.edu.unju.fi.service.IProvinciaService;

@Service("provinciaServiceImp")
public class ProvinciaServiceImp implements IProvinciaService {
	
	/* inyeccion de dependencias */
	
	@Autowired
	private IProvinciaRepository provinciaRepository;
	
	@Autowired
	private Provincia provincia;
	
	/**
	 * metodo para obtener un listado de todas provincias de la base de datos
	 * @author Yufra, Alejandro
	 * @return lista de objetos de tipo Provincia
	 */
	@Override
	public List<Provincia> getProvincias() {
		return (List<Provincia>) provinciaRepository.findAll();
	}
	
	/**
	 * guardar una provincia a la base de datos
	 * @author Yufra, Alejandro
	 * @param provincia de tipo Provincia
	 */
	@Override
	public void saveProvincia(Provincia provincia) {
		provinciaRepository.save(provincia);
	}

	/**
	 * nueva instancia de objeto Provincia
	 * @author Yufra, Alejandro
	 * @return objeto Provincia
	 */
	@Override
	public Provincia getProvincia() {
		return provincia;
	}

}
