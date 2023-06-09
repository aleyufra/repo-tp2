package ar.edu.unju.fi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Sucursal;

@Repository
public interface ISucursalRepository extends CrudRepository<Sucursal, Long> {
	
	/* buscamos las sucursales cuyo estado se encuentre en true */
	public List<Sucursal> findByEstado(boolean estado);
	
}