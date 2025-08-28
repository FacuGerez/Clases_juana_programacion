package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;

import java.util.Arrays;

public class Pizzeria implements Mostrable{
	private static final String MSG_FALTA_TOPPING = "No se pudo fabricar %s por falta de topping %s";
	private static final String MSG_PIZZA_TOPPINGS_NULO = "No se pudo fabricar Pizza o Topping nulo.";
	private static final String MSG_TOPPINGS = "Error de par�metros incorporando toppings";
	private static final String MSG_TOTALES = "La venta total fue: $%8.2f\n";
	private static final String MSG_CANTIDADES = "Se han fabricado: %d Tradicionales, %d Especiales y %d Rectangulares\n";
	// TODO A completar
	private String nombre;
	private int[][] totalToppings;
	private int[] totalPizzasPedidas;
	private ListaOrdenadaPizzas pizzas;
	private float totalVenta;
	private ColaNodos<String> erroresPizzeria; // falta de topping

	public Pizzeria(String nombre) {
		// TODO A completar
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException(MSG_PIZZA_TOPPINGS_NULO);
		}
		this.nombre = nombre;
		this.totalToppings = new int[TipoPizza.values().length][Topping.values().length];
        for (int[] totalTopping : totalToppings) {
            Arrays.fill(totalTopping, 0);
        }
		this.pizzas = new ListaOrdenadaPizzas();
		this.totalPizzasPedidas = new int[TipoPizza.values().length];
		for (TipoPizza tipoPizza : TipoPizza.values()) {
			this.totalPizzasPedidas[tipoPizza.ordinal()] = 0;
		}
		this.totalVenta = 0;
		this.erroresPizzeria = new ColaNodos<>();
	}

	// TODO A completar
	public void incorporarTopping(TipoPizza tipoPizza, Topping topping, int cantidad) {
		if (tipoPizza == null || topping == null || cantidad < 0) {
			throw new IllegalArgumentException(MSG_TOPPINGS);
		}
		totalToppings[tipoPizza.ordinal()][topping.ordinal()] += cantidad;
	}

	public void ingresarPedido(Pizza p, Topping topping) {
		// TODO A completar
		if (p == null || topping == null){
			erroresPizzeria.add(MSG_PIZZA_TOPPINGS_NULO);
			throw new IllegalArgumentException(MSG_PIZZA_TOPPINGS_NULO);
		}
		if (totalToppings[p.getTipoPizza().ordinal()][topping.ordinal()] <= 0) {
			String error = String.format(MSG_FALTA_TOPPING, p.getNombre(), topping.getNombre());
			erroresPizzeria.add(error);
			throw new IllegalArgumentException(error);
		}
		pizzas.add(p);
		totalVenta += p.getPrecioDeVenta();
		totalPizzasPedidas[p.getTipoPizza().ordinal()]++;
		totalToppings[p.getTipoPizza().ordinal()][topping.ordinal()]--;
	}

	public int vendidasConPrecioEntre(int precioMin, int precioMax){
		int cantidad = 0;
		for (Pizza p : pizzas) {
			if (p.getPrecioDeVenta() >= precioMin && p.getPrecioDeVenta() <= precioMax) {
				cantidad++;
			}
		}
		return cantidad;
	}

	@Override
	public void mostrar() {
		System.out.println("Pizzeria: " + nombre);
		System.out.printf(MSG_CANTIDADES, totalPizzasPedidas[1], totalPizzasPedidas[0], totalPizzasPedidas[2]);
		System.out.printf(MSG_TOTALES, totalVenta);
		System.out.println("--------------------------------------");
		System.out.println("Pizzas fabricadas por precio:");
		for (Pizza p : pizzas) {
			p.mostrar();
		}
		System.out.println("--------------------------------------");
		System.out.println("Pedidos con error:");
		while (!erroresPizzeria.isEmpty()) {
			System.out.println(erroresPizzeria.remove());
		}
		System.out.println("--------------------------------------");
	}

	// TODO A completar
}
