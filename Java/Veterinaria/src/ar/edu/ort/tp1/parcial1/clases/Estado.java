package ar.edu.ort.tp1.parcial1.clases;

public enum Estado {
	ENFERMO("Muy enfermo"), HAMBRIENTO("Tengo hambre"), FELIZ("Mas feliz que una lombriz");

	private String descripcion;

	private Estado(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
