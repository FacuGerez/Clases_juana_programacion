package ar.edu.ar.ort.parcial2.clases;

public class Registracion {

	private int dni;
	private String nombreCompleto;
	private String tituloPelicula;

	public Registracion(int dni, String nombreCompleto, String tituloPelicula) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.tituloPelicula = tituloPelicula;
	}

	public String getTituloPelicula() {
		return tituloPelicula;
	}

	public int getDni() {
		return dni;
	}

	public Acreditacion generarAcreditacion() {
		return new Acreditacion(dni, nombreCompleto);
	}

}
