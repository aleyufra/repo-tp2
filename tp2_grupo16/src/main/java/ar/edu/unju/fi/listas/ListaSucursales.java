package ar.edu.unju.fi.listas;
import java.util.List;
import ar.edu.unju.fi.model.Sucursal;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListaSucursales {
	
	private List<Sucursal> sucursales;

	public ListaSucursales() {
		sucursales = new ArrayList<Sucursal>();
		sucursales.add(new Sucursal("Patitas", "Av. Fasio 211", "Centro", "S. S. De Jujuy", LocalDate.of(2016, 3, 13), "3884767676"));
		sucursales.add(new Sucursal("El Arriero", "Calle. Urdininea 45", "Cuyaya", "S. S. De Jujuy", LocalDate.of(2019, 5, 26), "3884565565"));
		sucursales.add(new Sucursal("San Roque", "Independencia 453", "Centro", "S. S. De Jujuy", LocalDate.of(2020, 8, 9), "388487887"));
		sucursales.add(new Sucursal("Pet Shop", "Juana Manuela Gorriti", "Bajo Gorriti", "Palpalá", LocalDate.of(2018, 2, 20), "388478952"));
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}	
	
}
