package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Categoria;

@Repository
public interface ICategoriaRepository extends CrudRepository<Categoria, Long>{

	
}
