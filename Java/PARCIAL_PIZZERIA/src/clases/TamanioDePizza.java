package clases;

public enum TamanioDePizza {

	PERSONAL("Personal", 1f), MEDIANA("Mediana", 1.25f), FAMILIAR("Familiar", 1.5f);

	private final String 	descripcion;
	private final float porcentaje;

	TamanioDePizza(String descripcion, float porcentaje) {
		this.descripcion	= descripcion;
		this.porcentaje 	= porcentaje;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public float getPorcentaje() {
		return porcentaje;
	}

}
