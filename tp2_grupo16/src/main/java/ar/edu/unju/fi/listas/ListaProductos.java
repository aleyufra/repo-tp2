package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Producto;

@Component
public class ListaProductos {
	
	private List<Producto> productos;
	
	public ListaProductos() {
//		Categoria categoriaAlimentos = new Categoria("Alimentos");
//		Categoria categoriaAccesorios = new Categoria("Accesorios");
//		Categoria categoriaJuguetes = new Categoria("Juguetes");
//		productos = new ArrayList<Producto>();
//		productos.add(new Producto("Whiskas adulto", categoriaAlimentos, 1545, "https://d3ugyf2ht6aenh.cloudfront.net/stores/979/500/products/whiskas-carne1-011a38f44b2221309216395887991352-640-0.webp", 780.0, (byte) 30));
//		productos.add(new Producto("Natura adulto", categoriaAlimentos, 1247, "https://delkoalimentos.com.ar/contenido/lineas/1.png", 800.0, (byte) 10));
//		productos.add(new Producto("Pelotitas para perro", categoriaAccesorios, 7592, "https://ae01.alicdn.com/kf/Hd5e210561edc433dae3baa2c84fc17d3g.jpg_q50.jpg", 800.0, (byte) 10));
//		productos.add(new Producto("Cama para gato", categoriaAccesorios, 1856, "https://www.sonrisasdegato.com/wp-content/uploads/2016/08/cama-gato-830x429.jpg", 4200.0, (byte) 15));
//		productos.add(new Producto("Cama para perros", categoriaAccesorios, 9232, "https://http2.mlstatic.com/D_NQ_NP_870827-MLA46698499597_072021-O.webp", 4800.0, (byte) 15));
//		productos.add(new Producto("Pelota de plumas", categoriaJuguetes, 5467, "https://http2.mlstatic.com/D_NQ_NP_939111-MLA46382090824_062021-O.webp", 400.0, (byte) 3));
//		productos.add(new Producto("Sobre Dogchow para cachorros", categoriaAlimentos, 7698, "https://nanolog.vtexassets.com/arquivos/ids/162341/purina-dog-chow-cachorros-sabor-pollo-15x100g-D_NQ_NP_873309-MLA31077249206_062019-F--1-.jpg?v=637213536113270000", 300.0, (byte) 8));
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
