package ar.edu.unju.fi.listas;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Sucursal;

import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class ListaSucursales {
	
	private List<Sucursal> sucursales;

	public ListaSucursales() {
		sucursales = new ArrayList<Sucursal>();
//		sucursales.add(new Sucursal("Patitas", "Av. Fasio 211", "Centro", "San Salvador De Jujuy", LocalDate.of(2016, 3, 13), "388-4767676", "/sucursales-images/sucursal-patitas.jpg", "Abierto", true));
//		sucursales.add(new Sucursal("El arriero", "Calle. Urdininea 45", "Cuyaya", "San Salvador De Jujuy", LocalDate.of(2019, 5, 26), "388-4565565", "/sucursales-images/el-arriero.jpg", "Abierto",  true));   
//		sucursales.add(new Sucursal("San roque", "Independencia 453", "Centro", "San Salvador De Jujuy", LocalDate.of(2020, 8, 9), "388-4878872", "/sucursales-images/sucursal2.jpg", "Abierto", true));
//		sucursales.add(new Sucursal("Pet shop", "Juana Manuela Gorriti", "Bajo Gorriti", "Palpalá", LocalDate.of(2018, 2, 20), "388-4789529", "/sucursales-images/sucursal3.jpg", "Abierto", true));
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}	
	
}
