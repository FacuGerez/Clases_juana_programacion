package ar.edu.ort.tp1.pacial1.clases;

public enum TelaSillon {

	CHENILLE(20f), PANA(15f), GOBELINO(17);

	private float porcentaje;

	private TelaSillon(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public float getPorcentaje() {
		return porcentaje;
	}

}
