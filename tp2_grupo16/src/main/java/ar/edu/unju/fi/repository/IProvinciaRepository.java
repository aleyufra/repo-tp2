package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Provincia;

@Repository
public interface IProvinciaRepository extends CrudRepository<Provincia, Long>{

}
