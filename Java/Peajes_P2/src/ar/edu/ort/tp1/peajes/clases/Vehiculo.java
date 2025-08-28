package ar.edu.ort.tp1.peajes.clases;

public abstract class Vehiculo {
	private static final String MSG_ERROR_PESO    = "El Peso del vehiculo debe ser mayor a 0.";
	private static final String MSG_ERROR_PATENTE = "La patente no puede ser nula ni estar vacia.";
	// TODO A completar
	private String patente;
	private int pesoEnKilos;
	
	public Vehiculo(String patente, int pesoEnKilos) {
		// TODO A completar
		if (patente == null || patente.isEmpty()) {
			throw new IllegalArgumentException(MSG_ERROR_PATENTE);
		}
		if (pesoEnKilos <= 0) {
			throw new IllegalArgumentException(MSG_ERROR_PESO);
		}
		this.patente = patente;
		this.pesoEnKilos = pesoEnKilos;
	}
	public abstract float getImporte();

	@Override
	public String toString() {
		return "Vehiculo (" + this.getClass().getSimpleName() + ") [patente=" + patente + ", pesoEnKilos=" + pesoEnKilos + "]";
	}
	
	
}
