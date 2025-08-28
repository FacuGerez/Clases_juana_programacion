package clases;

import java.util.ArrayList;

public class Pizzeria implements Mostrable {

	private static final String MSG_TOTALES = "La venta total fue: $%8.2f\n";
	private static final String MSG_CANTIDADES = "Se han fabricado: %d Tradicionales, %d Especiales y %d Rectangulares\n";
	private static final String MSG_FABRICANDO = "Fabricando la Pizza: ";
	//TODO A completar
	private final ArrayList<Pizza> pizzasfabricadas;
	private final String razonSocial;
	private int cantidadTradicional, cantidadEspecial, cantidadRectangular;
	private float ventaTotal;

	public Pizzeria(String razonSocial) {
		this.pizzasfabricadas = new ArrayList<>();
		this.razonSocial = razonSocial;
		this.cantidadTradicional = 0;
		this.cantidadEspecial = 0;
		this.cantidadRectangular = 0;
		this.ventaTotal = 0;
	}

	@Override
	public void mostrar() {
		System.out.println("Pizzeria: " + razonSocial);
		System.out.printf(MSG_CANTIDADES,cantidadTradicional,cantidadEspecial,cantidadRectangular);
		System.out.printf(MSG_TOTALES,ventaTotal);
	}

	public boolean fabricar(Pizza m) {
		//TODO A completar
		if (m == null) {
			return false;
		}
		System.out.print(MSG_FABRICANDO);
		m.mostrar();
		switch (m.getTipoDePizza()){
			case TRADICIONAL -> cantidadTradicional += 1;
			case ESPECIAL -> cantidadEspecial += 1;
			case RECTANGULAR -> cantidadRectangular += 1;
		}
		ventaTotal += m.getPrecioDeVenta();
		pizzasfabricadas.add(m);
		return true;
	}


	/**
	 * Retorna la sumatoria de los precios de Venta de nombre de la pizza enviado por parametro. 
	 * @param nombre
	 * @return
	 */
	public float sumatoriaDePizzas(String nombre) {
		//TODO A completar
		float total = 0;
		for (Pizza p : pizzasfabricadas) {
			if (p.modeloCorrecto(nombre)) {
				total += p.getPrecioDeVenta();
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
		int cantidad = 0;
		for (Pizza p : pizzasfabricadas) {
			if (p.getPrecioDeVenta() >= precioInferior && p.getPrecioDeVenta() <= precioSuperior) {
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
		for (Pizza p : pizzasfabricadas) {
			if (p.modeloCorrecto(nombre)) {
				return p.getPrecioDeVenta();
			}
		}
		return precio;
	}
}
