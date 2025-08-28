package ar.edu.ort.tp1.pacial1.clases;

public enum MaterialSilla {

	MADERA(1f), METAL(1.5f), PLASTICO(2f);
	
	private float multiplicadorValor;

	private MaterialSilla(float multiplicadorValor) {
		this.multiplicadorValor = multiplicadorValor;
	}

	public float getMultiplicadorValor() {
		return multiplicadorValor;
	}
	
}
