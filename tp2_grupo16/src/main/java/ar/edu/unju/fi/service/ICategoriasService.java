package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Categoria;

public interface ICategoriasService {
	
	
	List<Categoria> listarCategorias();

	void guardarCategoria(Categoria categoria);
	
}
