package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Producto;

public class ListaProductos {
	
	private List<Producto> productos;

	public ListaProductos() {
		productos = new ArrayList<Producto>();
		Producto unProducto = new Producto("alimento para gato", "alimentos", 111, 500, (byte)50);
		productos.add(unProducto);
	}

	public List<Producto> getProductos() {
		return productos;
	}
}
