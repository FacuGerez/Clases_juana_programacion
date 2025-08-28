package ar.edu.ort.tp1.peajes.clases;

public enum TipoDeAcoplado {
	CAMION("Camion"			, 1.0f),
	TANQUE("Tanque"			, 1.2f),
	TOLVA("Tolva"			, 1.4f),
	PLATAFORMA("Plataforma"	, 1.6f);

	private String descripcion;
	private float multiplicador;

	private TipoDeAcoplado(String descripcion, float multiplicador) {
		this.descripcion 	= descripcion;
		this.multiplicador 	= multiplicador;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public float getMultiplicadorTipoDeAcoplado() {
		return multiplicador;
	}

}
