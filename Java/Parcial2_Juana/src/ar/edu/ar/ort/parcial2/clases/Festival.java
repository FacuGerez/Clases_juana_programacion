package ar.edu.ar.ort.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;

public class Festival {

	private static final int CANT_PELICULAS = 10;

	private Pelicula[] peliculas;
	private VIPsPorDNI dniVips;
	private Cola<Registracion> registraciones;

	public Festival(String[] titulos ) {
		dniVips = new VIPsPorDNI();
		registraciones = new ColaNodos<Registracion>();
		// haciendo esto se puede probar con menos películas
		peliculas = new Pelicula[Math.min(CANT_PELICULAS, titulos.length)];
		completarArrayPeliculas(titulos);
	}

	private Pelicula buscarPelicula(String tituloPelicula) {
		Pelicula pel = null;
		int index = 0;
		while (index < peliculas.length && pel == null) {
			if (this.peliculas[index].mismoTitulo(tituloPelicula)) {
				pel = this.peliculas[index];
			} else {
				index++;
			}
		}
		return pel;
	}
	
	public int[][] obtenerAcreditadosPorTipoDeFuncionYPelicula() {
		int[][] datos = new int[this.peliculas.length][TiposDeFuncion.values().length];
		for (int pel = 0; pel < datos.length; pel++) {
			datos[pel] = this.peliculas[pel].obtenerAcreditadosPorTipoDeFuncion();
		}
		return datos;
	}

	private boolean esVip(int dni) {
		return this.dniVips.exists(dni);
	}

	public void procesarRegistraciones() {
		while (!registraciones.isEmpty()) {
			Registracion registracion = this.registraciones.remove();
			Pelicula pelicula = buscarPelicula(registracion.getTituloPelicula());
			pelicula.acreditar(registracion, this.esVip(registracion.getDni()));
		}

	}

	// Metodos agregados para complementar la implementacion.
	public void agregarVIP(int dni) {
		dniVips.add(dni);
	}

	private void completarArrayPeliculas(String [] titulos) {
		for (int p = 0; p < titulos.length; p++) {
			peliculas[p] = new Pelicula(titulos[p]);
		}
	}

	public void registrar(String tituloPelicula, int dni, String nombreCompleto) {
		registraciones.add(new Registracion(dni, nombreCompleto, tituloPelicula));

	}
	// TODO: CORREGIDO FACU
	public void mostrarDatosDeAcreditaciones() {
		int[][] acreditados =  obtenerAcreditadosPorTipoDeFuncionYPelicula();
		for (int pel = 0; pel < acreditados.length; pel++) {
			System.out.println("Acreditados " + this.peliculas[pel].getTituloPelicula());
			int totalAcreditados = 0;
			for (int tipo = 0; tipo < acreditados[pel].length; tipo++) {
				System.out.printf("%s: %d -", TiposDeFuncion.values()[tipo], acreditados[pel][tipo]);
				totalAcreditados += acreditados[pel][tipo];
			}
			System.out.printf("TOTAL: %d\n", totalAcreditados);
		}
	}

	// TODO: CORREGIDO FACU
	public void crearFunciones() {
		for (int p = 0; p < this.peliculas.length; p++) {
			this.peliculas[p].generarFunciones();
		}
	}
	// TODO: CORREGIDO FACU
	public void listarFunciones() {
		System.out.println("------------------------------------------");
		for (int p = 0; p < this.peliculas.length; p++) {
			this.peliculas[p].mostrarFunciones();
		}
	}

}