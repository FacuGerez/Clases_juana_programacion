package ar.edu.ort.tp1.pacial1.clases;

import java.util.ArrayList;

public class Pizzeria implements Mostrable {

	private static final String MSG_TOTALES = "La venta total fue: $%8.2f\n";
	private static final String MSG_CANTIDADES = "Se han fabricado: %d Tradicionales, %d Especiales y %d Rectangulares\n";
	private static final String MSG_FABRICANDO = "Fabricando la Pizza: ";
	
	//TODO A completar
	private ArrayList<Pizza> pizzas;
	private String nombre;
	
	private double ventaTotal = 0;
	private int rectangulares = 0;
	private int especiales = 0;
	private int tradicionales = 0;
	
	public Pizzeria(String nombre) {
		this.pizzas = new ArrayList<>();
		setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean fabricar(Pizza m) {
		//TODO A completar
		boolean pudo = false;
		
		if(m != null) {
			pudo = true;
			System.out.printf(MSG_FABRICANDO);
			m.mostrar();
			if(m instanceof Tradicional) {
				tradicionales++;
			}else if(m instanceof Especial) {
				especiales++;
			}else if(m instanceof Rectangular) {
				rectangulares++;
			}
			ventaTotal += m.getPrecioDeVenta();
			pizzas.add(m);
		}else {
			System.out.println("Error frabricando una pizza Costo invalido");
		}
		return pudo;
	}

	/**
	 * Retorna la sumatoria de los precios de Venta de nombre de la pizza enviado por parametro. 
	 * @param nombre
	 * @return
	 */
	public float sumatoriaDePizzas(String nombre) {
		//TODO A completar
		float 	total = 0;
		for (Pizza pizza : pizzas) {
			if(pizza.getNombre().equals(nombre)) {
				total += pizza.getPrecioDeVenta();
			}
		}
		return total;
	}
	
	/**
	 * 	Retorna la cantidad de pizzas vendidas con el precio de venta entre los parametros enviados.
	 * 	Los valores enviados son inclusivos.
	 * @param precioInferior
	 * @param precioSuperior
	 * @return
	 */
	public int vendidasConPrecioEntre(float precioInferior, float precioSuperior) {
		//TODO A completar
		int 	cantidad = 0;
		for (Pizza pizza : pizzas) {
			if(pizza.getPrecioDeVenta() <= precioSuperior && pizza.getPrecioDeVenta() >= precioInferior) {
				cantidad++;
			}
		}
		return cantidad;
	}
	
	/**
	 * Retorna el precio de venta de la primer pizza enviada por parametro.
	 * En caso de no encontrarse retorna 0.
	 * @param nombre
	 * @return
	 */
	public float precioVentaDeLaPrimerPizza(String nombre) {
		//TODO A completar
		float precio = 0;
		boolean encontrada = false;
		int idx = 0;
		Pizza pizza;
		while (!encontrada && idx < this.pizzas.size()) {
			pizza = this.pizzas.get(idx);
			if (pizza.getNombre().equals(nombre)) {
				encontrada	= true;
				precio = pizza.getPrecioDeVenta();
			}
			idx++;
		}
		return precio;
	}

	@Override
	public void mostrar() {
		System.out.println("Pizzeria: " +this.nombre);
		System.out.printf(MSG_CANTIDADES, tradicionales, especiales, rectangulares);
		System.out.printf(MSG_TOTALES, ventaTotal);
	}
}
