package ar.edu.ort.tp1.examen.clases;

public class EnvioPirvadoExpress extends EnvioPrivado{

	@Override
	public float calcularPrecio(int kms, int peso) {
		return super.calcularPrecio(kms, peso) *  2;
	}

}
