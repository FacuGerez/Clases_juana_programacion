package ar.edu.ort.tp1.peajes.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;

public class Sensor {
	private static final String MSG_ERROR_TIPO_VEHICULO_INCORRECTO = "El tipo de vehículo [%s] no está soportado por la plataforma.";
	
	// TODO A completar
	private final Cola<Vehiculo> vehiculosProcesados;
	private final PilaNodos<Vehiculo> erroresVehiculos;
	private float importeTotalProcesados = 0.0f;
	private int cantidadProcesados = 0;

	public Sensor() {
		// TODO A completar
		vehiculosProcesados = new ColaNodos<>();
		erroresVehiculos = new PilaNodos<>();
	}
	
	/**
	 * Retorna true en el caso de que el vehiculo sea un Automovil, Camion o Motocicleta, sino retorna false.
	 * @param v el vehiculo.
	 * @return true en el caso de que el vehiculo sea un Automovil, Camion o Motocicleta, sino retorna false.
	 */
	private boolean isClaseVehiculoSoportada(Vehiculo v) {
		boolean retornar = false;
		if (v!=null) {
			if ((v instanceof Automovil) ||
				(v instanceof Camion) ||
				(v instanceof Motocicleta)) {
				retornar = true;
			}
		}
		return retornar;
	}
	
	/**
	 * Procesa el vehiculo y retorna el importe.
	 * En caso de que la clase no sea "soportada" arroja una Exception 
	 *  con el mensaje MSG_ERROR_TIPO_VEHICULO_INCORRECTO.
	 * @param v Vehiculo a procesar
	 * @return el Importe del peaje.
	 */
	public float procesarVehiculoRetornarImporte(Vehiculo v) {
		// TODO A completar
		// Utilizar estas constantes
		// 	MSG_ERROR_TIPO_VEHICULO_INCORRECTO
		if (!isClaseVehiculoSoportada(v)) {
			erroresVehiculos.push(v);
			throw new IllegalArgumentException(String.format(MSG_ERROR_TIPO_VEHICULO_INCORRECTO, v.getClass().getSimpleName()));
		}
		vehiculosProcesados.add(v);
		importeTotalProcesados += v.getImporte();
		cantidadProcesados++;
		return v.getImporte();
	}
	
	/**
	 * Este metodo retorna el importe total acumulado de los vehiculos que fueron procesados por el Sensor.
	 * Este metodo no elimina los elementos de la coleccion.
	 * @return el importe total acumulado de los vehiculos que fueron procesados por el Sensor.
	 */
	public float getImporteProcesados() {
		// TODO A completar
		return importeTotalProcesados;
	}
	
	/**
	 * Este metodo retorna la cantidad de vehiculos que fueron procesados por el Sensor.
	 * Este metodo no elimina los elementos de la coleccion.
	 * @return la cantidad de vehiculos que fueron procesados por el Sensor.
	 */
	public int getCantidadProcesados() {
		// TODO A completar
		return cantidadProcesados;
	}
}
