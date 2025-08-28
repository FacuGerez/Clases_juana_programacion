package ar.edu.ort.tp1.peajes.clases;

public class Motocicleta extends Vehiculo {
	private static final String MSG_ERROR_CILINDRADA = "La cilindrade debe ser un numero positivo menor que 5000.";
	private static final int MAX_CILINDRADA = 5000;
	private static final int IMPORTE_BASE = 100;
	
	// TODO A completar
	private int cilindrada;
	public Motocicleta(String patente, int pesoEnKilos, int cilindrada) {
		super(patente, pesoEnKilos);
		if (patente.length() != 4 || !patente.toUpperCase().startsWith("A")){
			throw new IllegalArgumentException("La patente de una motocicleta debe tener 4 caracteres y comenzar con 'A'.");
		}
		if (cilindrada < 0 || cilindrada > MAX_CILINDRADA) {
			throw new IllegalArgumentException(MSG_ERROR_CILINDRADA);
		}
		this.cilindrada = cilindrada;
	}

	@Override
	public float getImporte() {
		return IMPORTE_BASE + (cilindrada < 1500 ? (float) IMPORTE_BASE / 2 : IMPORTE_BASE);
	}
}
