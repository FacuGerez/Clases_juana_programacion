package ar.edu.ar.ort.parcial2.clases;

import java.util.ArrayList;

public class Pelicula {

	private static final int CANT_BUTACAS = 800;
	private String tituloPelicula;
	private final Nomina[] nominas = { new NominaPorDNI(CANT_BUTACAS), new NominaPorDNI(CANT_BUTACAS),
			new NominaPorOrdenDeLlegada() };

	// TODO: CORREGIDO FACU
	private ArrayList<Funcion> funciones = new ArrayList<>();

	public Pelicula(String titulo) {
		this.tituloPelicula = titulo;
	}

	public void acreditar(Registracion registracion, boolean esVip) {
		Acreditacion acreditacion = registracion.generarAcreditacion();
		if (esVip) {
			asignarAcreditacionVIP(acreditacion);
		} else {
			this.nominas[TiposDeFuncion.GENERAL.ordinal()].agregarAcreditacion(acreditacion);
		}
	}

	private void asignarAcreditacionVIP(Acreditacion acreditacion) {
		boolean asignada = false;
		int index = 0;
		while (!asignada && index < TiposDeFuncion.values().length) {
			if (nominas[index].hayDisponibilidad()) {
				nominas[index].agregarAcreditacion(acreditacion);
				asignada = true;
			} else {
				index++;
			}
		}
	}

	public boolean mismoTitulo(String tituloPelicula) {
		return this.tituloPelicula.equals(tituloPelicula);
	}


	// TODO: CORREGIDO FACU
	public int[] obtenerAcreditadosPorTipoDeFuncion() {
		int[] aux = new int[TiposDeFuncion.values().length];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = nominas[i].getCantidadAcreditaciones();
		}
		return aux;
	}
	// TODO: CORREGIDO FACU
	public int getFuncionesGeneralesNecesarias() {
		int funcionesGenerales = nominas[TiposDeFuncion.GENERAL.ordinal()].getCantidadAcreditaciones();
		return funcionesGenerales / CANT_BUTACAS + (funcionesGenerales % CANT_BUTACAS == 0 ? 0 : 1);
	}
	// TODO: CORREGIDO FACU
	public String getTituloPelicula() {
		return tituloPelicula;
	}
	// TODO: CORREGIDO FACU
	public void generarFunciones() {
		for (int i = 0; i < TiposDeFuncion.values().length; i++) {
			int cantidadAcreditaciones = nominas[i].getCantidadAcreditaciones();
			int cantFunciones = cantidadAcreditaciones / CANT_BUTACAS + (cantidadAcreditaciones % CANT_BUTACAS == 0 ? 0 : 1);
			for (int j = 0; j < cantFunciones; j++) {
				Funcion funcion = new Funcion(TiposDeFuncion.values()[i], tituloPelicula, nominas[i].getAcreditaciones());
				funciones.add(funcion);
			}
		}
	}
	// TODO: CORREGIDO FACU
	public void mostrarFunciones() {
		for (Funcion funcion : funciones) {
			System.out.println(funcion.toString());
		}
	}
}