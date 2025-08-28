package ar.edu.ar.ort.parcial2.clases;

import java.util.List;

public interface Nomina {

	public abstract boolean hayDisponibilidad();
	
	public abstract void agregarAcreditacion(Acreditacion acreditacion);

	public abstract int getCantidadAcreditaciones();

	public abstract Acreditacion obtenerAcreditacion(int dni);
	// TODO: CORREGIDO FACU
	public AcreditacionesPorDNI getAcreditaciones();

}