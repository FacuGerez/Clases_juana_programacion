package ar.edu.ar.ort.parcial2.clases;

import java.util.List;

public class NominaPorDNI implements Nomina {
	
	private AcreditacionesPorDNI acreditaciones;
	
	public NominaPorDNI(int limite) {
		acreditaciones = new AcreditacionesPorDNI(limite);
	}

	@Override
	public void agregarAcreditacion(Acreditacion acreditacion) {
		acreditaciones.add(acreditacion);
	}

	@Override
	public int getCantidadAcreditaciones() {
		return acreditaciones.size();
	}

	@Override
	public Acreditacion obtenerAcreditacion(int dni) {
		return acreditaciones.search(dni);
	}

	@Override
	public boolean hayDisponibilidad() {
		return !acreditaciones.isFull();
	}
	// TODO: CORREGIDO FACU
	@Override
	public AcreditacionesPorDNI getAcreditaciones() {
		return acreditaciones;
	}
}
