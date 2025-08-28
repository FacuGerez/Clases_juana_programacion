package ar.edu.ort.tp1.examen.clases;

public class Comida extends Producto {

	private static final float COEF_COCIDA = 1.08f;
	private boolean cocida;
	private int cantIngredientes;

	public Comida(String nombre, float precioBase, int peso, int cantIngredientes, boolean cocida, int id) {
		super(nombre, id, precioBase, peso);
		this.cocida = cocida;
		this.cantIngredientes = cantIngredientes;
	}

	@Override
	public float obtenerPrecio() {

		return getPrecioBase() * cantIngredientes * (cocida ? COEF_COCIDA : 1);
	}

	public boolean isCocida() {
		return cocida;
	}

	@Override
	public String mostrarDeCadaClase() {
		return "Cocida: " +cocida+ " - Precio Base: " +super.mostrarDeCadaClase();
	}
	
}