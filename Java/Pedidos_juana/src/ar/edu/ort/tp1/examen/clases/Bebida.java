package ar.edu.ort.tp1.examen.clases;

public class Bebida extends Producto {

	private static final int PESO_X_CM3 = 53;
	private Tamanio tamanio;

	public Bebida(String nombre, float precioBase, int peso, Tamanio tamanio, int id) {
		super(nombre, id, precioBase, peso);
		this.tamanio = tamanio;
	}

	@Override
	public float obtenerPrecio() {

		return getPrecioBase() * tamanio.getCoefPrecio();
	}

	@Override
	public int obtenerPeso() {

		return super.obtenerPeso() + PESO_X_CM3 * tamanio.getCapacidadCM3();
	}

	@Override
	public String mostrarDeCadaClase() {
		return "Tamaño: " + tamanio+ " - Precio base: " +super.mostrarDeCadaClase(); 
	}

}