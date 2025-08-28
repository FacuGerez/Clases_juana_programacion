package clases;

public enum AdicionalQueso {

	QUESO_SIMPLE("Queso Simple", 1), QUESO_DOBLE("Queso Doble", 1.5f), QUESO_TRIPLE("Queso Triple",2.3f);

	private final String descripcion;
	private final float multiplicadorValor;

	AdicionalQueso(String descripcion, float multiplicadorValor) {
		this.descripcion 		= descripcion;
		this.multiplicadorValor = multiplicadorValor;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public float getMultiplicadorQueso() {
		return multiplicadorValor;
	}

}
