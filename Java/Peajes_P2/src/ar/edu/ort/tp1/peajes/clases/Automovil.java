package ar.edu.ort.tp1.peajes.clases;

public class Automovil extends Vehiculo {
	private static final int IMPORTE_BASE = 250;

	// TODO A completar
	public Automovil(String patente, int pesoEnKilos) {
		super(patente, pesoEnKilos);
		if (patente.length() != 6){
			throw new IllegalArgumentException("La patente debe tener 6 caracteres.");
		}
	}

	@Override
	public float getImporte() {
		return IMPORTE_BASE;
	}
}
