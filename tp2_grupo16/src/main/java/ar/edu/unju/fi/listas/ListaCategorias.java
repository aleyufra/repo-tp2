package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.entity.Categoria;

public class ListaCategorias {
	private List<Categoria> categorias;
	
	public ListaCategorias() {
		categorias = new ArrayList<Categoria>();
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}
