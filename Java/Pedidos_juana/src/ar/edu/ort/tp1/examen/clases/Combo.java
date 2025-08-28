package ar.edu.ort.tp1.examen.clases;

import java.util.ArrayList;

public class Combo extends Item {

	private float descuento;
	private int pesoAcumulado;
	private float precioAcumulado;
	private ArrayList<Item> items;

	public Combo(String nombre, float descuento, int id) {
		super(nombre, id);
		pesoAcumulado = 0;
		precioAcumulado = 0;
		this.descuento = descuento;
		items = new ArrayList<Item>();
	}

	@Override
	public int obtenerPeso() {
		return this.pesoAcumulado;
	}

	@Override
	public float obtenerPrecio() {
		return this.precioAcumulado * (1 - descuento / 100);
	}

	public void agregarItem(Item item) {
		//Asumimos que item no será nulo
		this.items.add(item);
		this.pesoAcumulado += item.obtenerPeso();
		this.precioAcumulado += item.obtenerPrecio();
	}

	@Override
	public String mostrarDeCadaClase() {
		return "Cantidad de ítems: " +items.size()+ "Descuento: " +descuento;
	}

}