package ar.edu.ar.ort.parcial2;

import ar.edu.ar.ort.parcial2.clases.Festival;

public class Principal {
	// datos "cocinados" para que el programa funcione
	private static final String[] titulos = { "Arrival", "2001: Una Odisea del Espacio", "Solaris", "Alien",
			"Interstellar", "Dune", "Gravity", "WALL-E", "Silent Running", "Moon"

	};

	private static final int[] vips = { 12345678, 20202020, 22334455, 30303030, 33669912, 40404040, 50505050, 55555555,
			65535000, 98765432 };

	private static Festival festival = new Festival(titulos);

	public static void main(String[] args) {
		agregarVips();
		agregarRegistraciones();
		festival.procesarRegistraciones();
		// TODO - Implementar lo que falla a continuacion
		festival.mostrarDatosDeAcreditaciones();
		festival.crearFunciones();
		festival.listarFunciones();
	}

	private static void agregarRegistraciones() {
		for (int t = 0; t < titulos.length; t++) {
			festival.registrar(titulos[t], vips[t], "VIP " + vips[t]);
			festival.registrar(titulos[t], 20225712, "Dany V");
			if (t % 2 == 0) {
				festival.registrar(titulos[t], 34433443, "Charly B");
			}
			if (t % 3 == 0) {
				festival.registrar(titulos[t], 43515000, "Kami K");
			}
			if (t % 4 == 0) {
				festival.registrar(titulos[t], 32231441, "Paul Yu");
			}
			if (t % 5 == 0) {
				festival.registrar(titulos[t], 31281281, "Jules S");
			}
		}
	}

	private static void agregarVips() {
		for (int v = 0; v < vips.length; v++) {
			festival.agregarVIP(vips[v]);
		}
	}

}
