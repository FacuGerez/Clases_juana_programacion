package ar.edu.ort.tp1.examen.clases;

public class EnvioNormal implements FormaDeEnvio{

	@Override
	public float calcularPrecio(int kms, int peso) {
		return kms * PRECIO_BASE;
	}

}
