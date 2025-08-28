package ar.ort.tp1.parcial1;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public class Coordenada {

	private int latitud;
	private int longitud;

	public Coordenada(int latitud, int longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return String.format("{%d;%d}", latitud, longitud);
	}

	public boolean coincideCon(Coordenada coord) {
		return this.latitud == coord.latitud && this.longitud == coord.longitud;
	}
}