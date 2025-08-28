package ar.edu.ar.ort.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class VIPsPorDNI extends ListaOrdenadaNodos<Integer, Integer>{

	@Override
	public int compare(Integer dato1, Integer dato2) {
		return dato1.compareTo(dato2);
	}

	@Override
	public int compareByKey(Integer clave, Integer elemento) {
		return clave.compareTo(elemento);
	}

}
