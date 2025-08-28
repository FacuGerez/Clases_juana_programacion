package ar.edu.ort.tp1.examen.clases;

public interface FormaDeEnvio {

	public static final float PRECIO_BASE = 150;
	
	public float calcularPrecio(int kms, int peso);
}
