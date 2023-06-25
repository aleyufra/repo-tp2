package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.repository.IProvinciaRepository;
import ar.edu.unju.fi.service.IProvinciaService;

@Service("provinciaServiceImp")
public class ProvinciaServiceImp implements IProvinciaService {
	
	@Autowired
	private IProvinciaRepository provinciaRepository;
	
	@Autowired
	private Provincia provincia;
	
	@Override
	public List<Provincia> getProvincias() {
		return (List<Provincia>) provinciaRepository.findAll();
	}

	@Override
	public void saveProvincia(Provincia provincia) {
		provinciaRepository.save(provincia);
	}

	@Override
	public Provincia getProvincia() {
		return provincia;
	}

}
