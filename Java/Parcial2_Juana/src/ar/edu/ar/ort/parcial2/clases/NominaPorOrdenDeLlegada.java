package ar.edu.ar.ort.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;

public class NominaPorOrdenDeLlegada implements Nomina {

	private Cola<Acreditacion> acreditaciones;
	private int cantidadAcreditaciones;

	public NominaPorOrdenDeLlegada() {
		acreditaciones = new ColaNodos<Acreditacion>();
		cantidadAcreditaciones = 0;
	}

	@Override
	public void agregarAcreditacion(Acreditacion acreditacion) {
		this.acreditaciones.add(acreditacion);
		cantidadAcreditaciones++;
	}

	@Override
	public int getCantidadAcreditaciones() {
		return cantidadAcreditaciones;
	}

	@Override
	public Acreditacion obtenerAcreditacion(int dni) {
		Acreditacion resultado = null;
		acreditaciones.add(null);
		Acreditacion temp = acreditaciones.remove();
		while(temp != null) {
			if (resultado == null && temp.getDni() == dni) {
				resultado = temp;
			}
			acreditaciones.add(temp);
			temp = acreditaciones.remove();
		}
		return resultado;
	}

	@Override
	public boolean hayDisponibilidad() {
		return true;
	}


	//TODO: CORREGIDO FACU
	@Override
	public AcreditacionesPorDNI getAcreditaciones() {
		AcreditacionesPorDNI listaAcreditaciones = new AcreditacionesPorDNI(cantidadAcreditaciones + 1);
		acreditaciones.add(null);
		Acreditacion aux = acreditaciones.remove();
		while (aux != null) {
			listaAcreditaciones.add(aux);
			acreditaciones.add(aux);
			aux = acreditaciones.remove();
		}
		return listaAcreditaciones;
	}
}