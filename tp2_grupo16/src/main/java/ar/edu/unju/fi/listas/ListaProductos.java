package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Producto;

@Component
public class ListaProductos {
	
	private List<Producto> productos;

	public ListaProductos() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto("Whiscas adulto", "Alimentos", 4536, 800.00, (byte)50));
		productos.add(new Producto("Pedigree cachorros", "Alimentos", 6328, 600.00, (byte)10));
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
