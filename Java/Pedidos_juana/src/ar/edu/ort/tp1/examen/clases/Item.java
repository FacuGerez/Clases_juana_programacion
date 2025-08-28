package ar.edu.ort.tp1.examen.clases;

public abstract class Item implements Mostrable, Enviable{

	private String nombre;
	private int id;
	private int cantidad;

	public Item(String nombre, int id) {
		this.nombre = nombre;
		setId(id);
		this.cantidad = 1;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean mismoItem(int idItem) {
		return this.id == idItem;
	}

	@Override
	public void mostrar() {
		System.out.println(getClass().getSimpleName() +nombre+ "(" +id+ ") " + mostrarDeCadaClase());
	}

	public abstract String mostrarDeCadaClase();
}