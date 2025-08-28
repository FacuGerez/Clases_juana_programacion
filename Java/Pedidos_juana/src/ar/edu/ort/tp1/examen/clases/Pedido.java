package ar.edu.ort.tp1.examen.clases;

import java.util.ArrayList;

public class Pedido {

	private ArrayList<Item> items;
	private FormaDeEnvio forma;
	private int kms;
	
	public Pedido(FormaDeEnvio forma, int kms) {
		this.items = new ArrayList<>();
		this.forma = forma;
		this.kms = kms;
	}

	public void agregarItem(Item item, int cantidad) {
		if(item == null) {
			return;
		}
		Item duplicado = null;
		for (Item item1 : items) {
			if(item1.equals(item)) {
				duplicado = item1;
				item1.setCantidad(item1.getCantidad() + 1);
			}
		}if(duplicado == null) {
			item.setCantidad(cantidad);
			items.add(item);
		}
		System.out.println("Se agrego la cantidad de " +cantidad+ " del item: ");
		item.mostrar();
	}

	public void quitarItems(Item item, int cantidad) {
		Item duplicado = null;
		for (Item item2 : items) {
			if(item2.equals(item)) {
				item2.setCantidad(item2.getCantidad() - cantidad);
				duplicado = item2;
			}
		}
		if(duplicado == null) {
			System.out.println("No se logró quitar el item, porque no estaba en el pedido");
		}else if(duplicado.getCantidad() == 0) {
			items.remove(duplicado);
			System.out.println("Se ha retirado " +cantidad+ " cantidad del item.");
		}		
	}

	//Nose
	public InfoVenta evaluar() {
		int peso = 0;
		float precio = 0;
		for (Item item : items) {
			peso += item.obtenerPeso();
			precio += item.obtenerPrecio();
		}
		return new InfoVenta(precio, peso);
	}
	
	public float precioTotalConEnvio() {
		float precioTotal = 0;
		int pesoTotal = 0;
		for (Item item : items) {
			precioTotal += item.obtenerPrecio();
			pesoTotal += item.obtenerPeso();
		}
		precioTotal += forma.calcularPrecio(kms, pesoTotal);
		return precioTotal;
	}

}