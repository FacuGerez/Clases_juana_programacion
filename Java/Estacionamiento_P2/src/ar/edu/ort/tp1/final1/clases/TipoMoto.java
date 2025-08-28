package ar.edu.ort.tp1.final1.clases;

public enum TipoMoto {
	CICLOMOTOR(1.2), SCOOTER(1.25), MOTOCROSS(3), CRUISER(2.4);
	
	private final double indice;
	TipoMoto(double indice) {
		this.indice = indice;
	}
	
	public double getIndice() {
		return indice;
	}
}
