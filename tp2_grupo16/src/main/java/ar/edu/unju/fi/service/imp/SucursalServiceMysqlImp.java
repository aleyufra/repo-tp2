package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Service("sucursalServiceMysqlImp")
public class SucursalServiceMysqlImp implements ISucursalService {

	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private Sucursal sucursal;
	
	@Override
	public List<Sucursal> listarSucursales() {
		return sucursalRepository.findByEstado(true);
	}

	@Override
	public void guardarSucursal(@Valid Sucursal sucursal) {
		if (sucursal.getEstadoStr().equals("Abierto")) {
			sucursal.setEstado(true);
		} else if (sucursal.getEstadoStr().equals("Cerrado")) {
			sucursal.setEstado(false);
		}
		sucursalRepository.save(sucursal);
	}

	@Override
	public void modificarSucursal(Sucursal sucursal) {
		if (sucursal.getEstadoStr().equals("Abierto")) {
			sucursal.setEstado(true);
		} else if (sucursal.getEstadoStr().equals("Cerrado")) {
			sucursal.setEstado(false);
		}
		sucursalRepository.save(sucursal);
	}

	@Override
	public void eliminarSucursal(Long id) {
		Sucursal sucu = sucursalRepository.findById(id).get();
		sucu.setEstado(false);
		sucursalRepository.save(sucu);
	}


	@Override
	public Sucursal getById(Long id) {
		return sucursalRepository.findById(id).get();
	}

	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}
}
