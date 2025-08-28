package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;
import ar.edu.ort.tp1.tdas.interfaces.ListaOrdenada;

public class TiendaDeJuegos implements Mostrable {

	private static final String MSG_JUEGO_NULO = "No se pudo fabricar Juego o Cupon nulo.";
	private static final String MSG_TIPO_DE_JUEGO = "Error de parametros incorporando tipos de juegos";
	private static final String MSG_TOTALES = "La venta total fue: $%8.2f\n";
	public static final String MENSAJE_FABRICA_POR_TIPO = "Se han fabricado: %d RPG, %d Aventura, %d Plataformas y %d Carreras\n";
	
	private String nombre;
	private int[][] cantCuponesXTipoJuego;
	private Cola<String> errores;
	private ListaOrdenada<Float, Juego> listaJuegos;
	
	private float importeTotal = 0;
	private int rpgs = 0;
	private int aventuras = 0;
	private int plataformas = 0;
	private int carreras = 0;

	public TiendaDeJuegos(String nombre) {
		setNombre(nombre);
		this.cantCuponesXTipoJuego = new int[Cupon.values().length][TipoDeJuego.values().length];
		for (int i = 0; i < cantCuponesXTipoJuego.length; i++) {
			for (int j = 0; j < cantCuponesXTipoJuego[i].length; j++) {
				cantCuponesXTipoJuego[i][j] = 0;
			}
		}
		this.errores = new ColaNodos<>();
		this.listaJuegos = new ListaOrdenadaJuegos();
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException("Nombre de Juego Invalido");
		}
		this.nombre = nombre;
	}

	//VER
	public void ingresarCuponesDeJuegos(TipoDeJuego tipoDeJuego, Cupon cupon, int cantidad) {
		if(tipoDeJuego == null || cupon == null || cantidad <= 0) {
			throw new IllegalArgumentException(MSG_TIPO_DE_JUEGO);
		}
		
		this.cantCuponesXTipoJuego[cupon.ordinal()][tipoDeJuego.ordinal()] += cantidad;

	}


	public void ingresarPedido(Juego juego, Cupon cupon) {
		//Practicar lo de error. Esto se hace cuando tengo constante
		String error;
		if(juego == null || cupon == null) {
			this.errores.add(MSG_JUEGO_NULO);
			throw new IllegalArgumentException(MSG_JUEGO_NULO);
		}
		//Practicar de error. Este se hace cuando no tengo constante
		if(!veritificarStockDeCupones(cupon, juego.getTipoDeJuego())) {
			error = "No se pudo ingresar " +juego.getTipoJuego().getDescripcion()+ " por falta de cupon " + juego.getCupon().getNombre();
			this.errores.add(error);
			throw new IllegalArgumentException(error);
		}
		this.importeTotal += juego.getPrecioDeVenta();
		actualizarStock(juego.getTipo(), cupon);
		this.listaJuegos.add(juego);
	}

	public int cantidadDeJuegosEntrePrecios(float precioMinimo, float precioMaximo) {
		int juegos = 0;
		for (Juego juego : listaJuegos) {
			if(juego.getPrecioDeVenta() >= precioMinimo && juego.getPrecioDeVenta() <= precioMaximo) {
				juegos++;
			}
		}
		return juegos;
	}

	public boolean veritificarStockDeCupones(Cupon cupon, TipoDeJuego tipoDeJuego) {
		return this.cantCuponesXTipoJuego[cupon.ordinal()][tipoDeJuego.ordinal()] >= 1;
	}
	public int actualizarStock(TipoDeJuego tipoDeJuego, Cupon cupon) {
		return this.cantCuponesXTipoJuego[cupon.ordinal()][tipoDeJuego.ordinal()]--;
	}

	public void mostrarJuegos() {
		for (Juego juego : listaJuegos) {
			juego.mostrar();
		}
	}
	
	public void mostrarJuegosXTipo(Cupon cupon, TipoDeJuego tipoDeJuegos) {
		rpgs = this.cantCuponesXTipoJuego[cupon.ordinal()][TipoDeJuego.RPG.ordinal()]++;
		aventuras = this.cantCuponesXTipoJuego[cupon.ordinal()][TipoDeJuego.AVENTURA.ordinal()]++;
		plataformas = this.cantCuponesXTipoJuego[cupon.ordinal()][TipoDeJuego.PLATAFORMAS.ordinal()]++;
		carreras = this.cantCuponesXTipoJuego[cupon.ordinal()][TipoDeJuego.CARRERAS.ordinal()]++;
	}
	
	public void mostrarPedidosConError() {
		System.out.println("Pedidos con error");
		String error;
		String centinela = null;
		this.errores.add(centinela);
		error = this.errores.remove();
		
		while(error != centinela) {
			System.out.println(error);
			this.errores.add(error);
			error = this.errores.remove();
		}
	}
	
	@Override
	public void mostrar() {
		System.out.println("TiendaDeJuegos: " +this.getNombre());

		System.out.printf(MENSAJE_FABRICA_POR_TIPO, this.rpgs, this.aventuras, this.plataformas, this.carreras);
		System.out.printf(MSG_TOTALES, this.importeTotal);
		System.out.println("--------------------------------------");
		mostrarJuegos();
		System.out.println("--------------------------------------");
		mostrarPedidosConError();
	}

}
