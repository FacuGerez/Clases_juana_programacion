package ar.edu.ort.tp1.examen.clases;

public class EnvioPrivado implements FormaDeEnvio{

	public static final int PRECIO = 100;
	
	@Override
	public float calcularPrecio(int kms, int peso) {
		float precio = 0;
		if(peso <= 100) {
			precio = (PRECIO_BASE * 2) * kms;
		}else {
			precio = (PRECIO_BASE * 5) * kms;
		}
		return precio;
	}

}
