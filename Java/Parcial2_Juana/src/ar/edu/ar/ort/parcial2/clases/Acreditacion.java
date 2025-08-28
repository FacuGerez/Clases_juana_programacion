package ar.edu.ar.ort.parcial2.clases;

public class Acreditacion {

	private int dni;
	private String nombreCompleto;

	public Acreditacion(int dni, String nombreCompleto) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
	}

	public int getDni() {
		return dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

}
