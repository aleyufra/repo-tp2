package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.repository.ICategoriaRepository;
import ar.edu.unju.fi.service.ICategoriasService;

@Service("categoriasServiceMysqlImp")
public class CategoriaServiceMysqlImp implements ICategoriasService {
	
	@Autowired
	private ICategoriaRepository categoriaRepository;
	
	
	@Override
	public List<Categoria> listarCategorias() {
		return (List<Categoria>) categoriaRepository.findAll();
	}


	@Override
	public void guardarCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
		
	}

}
