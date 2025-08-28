package ar.edu.ort.tp1.peajes.clases;

public class Camion extends Vehiculo {
	private static final int IMPORTE_BASE = 500;
	
	// TODO A completar
	private TipoDeAcoplado tipoDeAcoplado;
	public Camion(String patente, int pesoEnKilos, TipoDeAcoplado tipoDeAcoplado) {
		super(patente, pesoEnKilos);
		if (patente.length() <= 6 || !patente.contains(" ")) {
			throw new IllegalArgumentException("La patente de un camión debe tener más de 6 caracteres y contener un espacio.");
		}
		if (tipoDeAcoplado == null) {
			throw new IllegalArgumentException("El tipo de acoplado no puede ser nulo.");
		}
		this.tipoDeAcoplado = tipoDeAcoplado;
	}

	@Override
	public float getImporte() {
		return IMPORTE_BASE +  IMPORTE_BASE * tipoDeAcoplado.getMultiplicadorTipoDeAcoplado();
	}
}
