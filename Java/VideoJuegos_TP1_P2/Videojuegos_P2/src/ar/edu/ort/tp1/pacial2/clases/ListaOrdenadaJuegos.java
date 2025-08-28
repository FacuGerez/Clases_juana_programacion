package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaOrdenadaJuegos extends ListaOrdenadaNodos<Float, Juego>{

	@Override
	public int compare(Juego dato1, Juego dato2) {
		return Float.valueOf(dato1.getPrecioDeVenta()).compareTo(Float.valueOf(dato2.getPrecioDeVenta()));
	}

	@Override
	public int compareByKey(Float clave, Juego elemento) {
		return clave.compareTo(Float.valueOf(elemento.getPrecioDeVenta()));
	}
}
