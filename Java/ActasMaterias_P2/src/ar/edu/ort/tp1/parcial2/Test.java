package ar.edu.ort.tp1.parcial2;

import ar.edu.ort.tp1.parcial2.modelo.Instituto;

public class Test {

	public static void main(String[] args) {
		Instituto i = new Instituto("ORT");
		cambiarNotas(i);
		i.informarActasPorMateriaYCurso();
	}
	
	public static void cambiarNotas(Instituto i) {
		 i.cambiarNota("Mat1", 10000001, 10);
		 i.cambiarNota("Mat1", 20000001, 5);
		 i.cambiarNota("Programacion", 10000001, 5);
		 i.cambiarNota("Mat1", -3, 5);
		 i.cambiarNota("Mat1", 10000001, -5);
	}

}
