package ar.ort.tp1.parcial1;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public class Matematica {

	public static double promedio(double sumatoria, int cantidad) {
		return cantidad == 0 ? 0 : sumatoria / cantidad;
	}

	public static double porcentaje(int casos, int total) {
		return total == 0 ? 0 : casos * 100.0 / total;
	}

}