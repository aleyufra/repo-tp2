package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Consejo;

@Component
public class ListaConsejos {
	
	private List<Consejo> consejos;

	/**
	 * lista pre cargada de muestra
	 */
	public ListaConsejos() {
		consejos = new ArrayList<Consejo>();
		consejos.add(new Consejo("Control de pulgas y garrapatas", "Higiene","Las pulgas y las garrapatas son parásitos comunes que pueden causar molestias y transmitir enfermedades a tu mascota. Es importante utilizar productos antipulgas y garrapatas recomendados por tu veterinario para proteger a tu mascota. En nuestra tienda de mascotas, ofrecemos una amplia gama de productos antipulgas y garrapatas, incluyendo collares, pipetas y sprays. Es importante seguir las instrucciones del fabricante y aplicar los productos de acuerdo a la edad, tamaño y especie de tu mascota. Además, es fundamental revisar a tu mascota regularmente en busca de pulgas y garrapatas, especialmente después de paseos al aire libre o en áreas con alta infestación. Si encuentras pulgas o garrapatas en tu mascota, es importante eliminarlas adecuadamente y tratar a tu mascota y su entorno para prevenir una reinfestación."));
		consejos.add(new Consejo("Cuidado de pelaje", "Salud","Cepillar regularmente el pelaje de tu mascota ayuda a mantenerlo limpio, libre de enredos y brillante. El cepillado también estimula la piel y mejora la circulación sanguínea. Además, un pelaje bien cuidado puede prevenir problemas de salud, como infecciones de la piel y alergias. En nuestra tienda de mascotas, ofrecemos una variedad de cepillos y peines que se adaptan a diferentes tipos de pelaje. Consulta con nuestros expertos para saber cuál es el mejor para tu mascota."));
		consejos.add(new Consejo("Ejercicio regular", "Entrenamiento","Cepillar regularmente el pelaje de tu mascota ayuda a mantenerlo limpio, libre de enredos y brillante. El cepillado también estimula la piel y mejora la circulación sanguínea. Además, un pelaje bien cuidado puede prevenir problemas de salud, como infecciones de la piel y alergias. En nuestra tienda de mascotas, ofrecemos una variedad de cepillos y peines que se adaptan a diferentes tipos de pelaje. Consulta con nuestros expertos para saber cuál es el mejor para tu mascota."));
	}

	public List<Consejo> getConsejos() {
		return consejos;
	}

	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}

}
