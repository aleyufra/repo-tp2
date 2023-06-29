package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Service("consejoServiceMysqlImp")
public class ConsejoServiceMysqlImp implements IConsejoService {
	
	/* inyeccion de dependencias */
	
	@Autowired
	private IConsejoRepository consejoRepository;
	
	@Autowired
	private Consejo consejo;
	
	/**
	 * metodo para obtener el listado de consejos
	 * @author Yufra, Alejandro
	 * @return obteto List cargado con objetos de tipo Consejo 
	 */
	@Override
	public List<Consejo> listarConsejos() {
		return (List<Consejo>) consejoRepository.findAll();
	}

	/**
	 *  metodo para guardar un consejo a la base de datos
	 *  @author Yufra, Alejandro
	 */
	@Override
	public void guardarConsejo(@Valid Consejo consejo) {
		consejoRepository.save(consejo);
	}
	
	/**
	 * metodo para modificar un consejo de la base de datos
	 * @author Yufra, Alejandro
	 * @param objeto de tipo Consejo
	 */
	@Override
	public void modificarConsejo(Consejo consejo) {
		consejoRepository.save(consejo);
	}
	
	/**
	 * metodo para eliminar un consejo de la base de datos
	 * @author Yufra, Alejandro
	 * @param id del objeto Consejo
	 */
	@Override
	public void eliminarConsejo(Long id) {
		Consejo cons = consejoRepository.findById(id).get();
		consejoRepository.delete(cons);
	}
	
	/**
	 * metodo para buscar un objeto Consejo de la base de datos por su id
	 * author Yufra, Alejandro
	 * @param id del objeto Consejo
	 * @return objeto de tipo Consejo
	 */
	@Override
	public Consejo getBy(Long id) {
		return consejoRepository.findById(id).get();

	}
	
	/**
	 * metodo para obtener una nueva instancia de un objeto Consejo
	 * @return objeto de tipo Consejo
	 */
	@Override
	public Consejo getConsejo() {
		return consejo;
	}

}
