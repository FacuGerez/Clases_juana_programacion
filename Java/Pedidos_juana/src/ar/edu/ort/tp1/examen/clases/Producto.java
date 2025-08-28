package ar.edu.ort.tp1.examen.clases;

public abstract class Producto extends Item {

	private float precioBase;
	private int peso;

	public Producto(String nombre, int id, float precioBase, int peso) {
		
		super(nombre, id);
		this.precioBase = precioBase;
		this.peso = peso;
	}

	protected float getPrecioBase() {
		
		return this.precioBase;
	}

	@Override
	public float obtenerPrecio() {
		return precioBase;
	}

	@Override
	public int obtenerPeso() {
		return peso;
	}

	@Override
	public String mostrarDeCadaClase() {
		return "Precio base: " +precioBase;
	}

}