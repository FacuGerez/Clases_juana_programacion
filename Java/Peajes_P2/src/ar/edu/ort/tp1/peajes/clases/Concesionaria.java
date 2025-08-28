package ar.edu.ort.tp1.peajes.clases;

import java.util.ArrayList;

public class Concesionaria  implements Mostrable{
	private static final String MSG_PORTICO_AGREGADO 	= "Se ha agregado el pórtico [%s]";
	private static final String MSG_ERROR_NOMBRE_CONCESIONARIA = "El nombre de la concesionaria no puede ser nulo ni estar vacío.";
	private static final String MSG_ERROR_PORTICO_INEXISTENTE  = "El pórtico [%s] no existe.";
	private static final String MSG_ERROR_PROCESANDO_VEHICULO  = "Error procesando el vehículo [%s].";
	// TODO A completar
	private static final int N_PORTICOS = 3;
	private String nombre;
	private ArrayList<Portico> porticos;
	private ArrayList<String> errores;

	public Concesionaria(String nombre) {
		// TODO A completar
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException(MSG_ERROR_NOMBRE_CONCESIONARIA);
		}
		this.nombre = nombre;
		this.porticos = new ArrayList<>(N_PORTICOS);
		this.errores = new ArrayList<>();
	}
	
	/**
	 * Este metodo agrega el portico a la concesionaria.
	 * @param nombre
	 */
	public void agregarPortico(String nombre) {
		// TODO A completar
		try {
			porticos.add(new Portico(nombre));
			System.out.println(String.format(MSG_PORTICO_AGREGADO, nombre));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Procesar el vehiculo en el portico especificado.
	 * Si el portico es inexistente o el proceso falla, se debe almacenar el error.
	 * @param nombrePortico es el nombre del Portico por donde paso el vehiculo,
	 * @param vehiculo es el vehiculo a procesar.
	 * @param carril es el carril (sensor) por el que paso el vehiculo.
	 */
	public void procesarVehiculo(String nombrePortico, Vehiculo vehiculo, int carril) {
		// TODO A completar
		// Utilizar estas constantes
		//	MSG_ERROR_PORTICO_INEXISTENTE
		//	MSG_ERROR_PROCESANDO_VEHICULO
		try{
			Portico portico = null;
			for (Portico p : porticos) {
				if (p.getNombre().equalsIgnoreCase(nombrePortico)) {
					portico = p;
					break;
				}
			}

			if (portico == null) {
				throw new IllegalArgumentException(String.format(MSG_ERROR_PORTICO_INEXISTENTE, nombrePortico));
			}
			try {
				portico.procesarVehiculo(vehiculo, carril);
			} catch (Exception e) {
				throw new Exception(String.format(MSG_ERROR_PROCESANDO_VEHICULO,e.getMessage()));
			}

		} catch (Exception e) {
			errores.add("ERROR: " + e.getMessage());
		}
	}
	
	/**
	 * Muestra por consola los errores recolectados según su orden cronológico de aparición.
	 */
	private void mostrarErrores() {
		// TODO A completar
		System.out.println("\n--------------- MOSTRAR ERRORES ---------------");
		for (String error : errores) {
			System.out.println(error);
		}
	}
	
	/**
	 * Muestra por consola las estadisticas de cada uno de los porticos, ordenado por nombre de portico.
	 */
	private void mostrarEstadisticasPorticos() {
		// TODO A completar
		System.out.println("\n--------------- MOSTRAR ESTADISTICAS PORTICOS ---------------");
		for (Portico portico : porticos) {
			portico.mostrarEstadisticas();
		}
	}

	@Override
	public void mostrarEstadisticas() {
		mostrarEstadisticasPorticos();
		mostrarErrores();
	}
}
