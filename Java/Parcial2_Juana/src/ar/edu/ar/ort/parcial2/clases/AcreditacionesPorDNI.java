package ar.edu.ar.ort.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class AcreditacionesPorDNI extends ListaOrdenadaNodos<Integer, Acreditacion> {

	public AcreditacionesPorDNI(int limite) {
		super(limite);
	}

	@Override
	public int compare(Acreditacion acreditacion1, Acreditacion acreditacion2) {
		return Integer.compare(acreditacion1.getDni(), acreditacion2.getDni());
	}

	@Override
	public int compareByKey(Integer clave, Acreditacion acreditacion) {
		return clave.compareTo(acreditacion.getDni());
	}

}
