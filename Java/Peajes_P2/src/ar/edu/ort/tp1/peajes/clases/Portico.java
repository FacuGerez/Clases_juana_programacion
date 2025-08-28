package ar.edu.ort.tp1.peajes.clases;

public class Portico implements Mostrable {
	private static final String MSG_PORTICO_ESTADISTICA  = "Estadísticas del pórtico [%-10s] es [%8.2f]";
	private static final String MSG_VEHICULO_PROCESADO   = "Se procesó [%-10s] Carril/Sensor [%d]";
	private static final String MSG_ERROR_NOMBRE_PORTICO = "El nombre del pórtico no puede ser nulo ni estar vacío.";
	private static final int CANTIDAD_CARRILES = 4;
	private Sensor [] sensores;
	// TODO A completar
	private String nombre;
	
	public Portico(String nombre) {
		// TODO A completar
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException(MSG_ERROR_NOMBRE_PORTICO);
		}
		this.nombre = nombre;
		sensores = new Sensor[CANTIDAD_CARRILES];
		crearSensores();
	}
	
	public String getNombre() {
		// TODO A completar
		return nombre;
	}
	
	/**
	 * Metodo responsable de Instanciar los sensores.
	 */
	private void crearSensores() {
		for (int i = 0; i < CANTIDAD_CARRILES; i++) {
			sensores[i] = new Sensor();
		}
	}
	
	/**
	 * Metodo responsable de procesar el vehiculo en el carril/sensor indicado y retornar el importe.
	 * 
	 * @param v Es el Vehiculo, que no puede ser nulo, sino se debe informar en los Errores.
	 * @param carril Es el carril (sensor) por el que paso el vehiculo.
	 */
	public float procesarVehiculo(Vehiculo v, int carril) {
		// TODO A completar
		// Utilizar esta constante
		// 	MSG_VEHICULO_PROCESADO
		float importe = sensores[carril].procesarVehiculoRetornarImporte(v);
		System.out.println(String.format(MSG_VEHICULO_PROCESADO, v.toString(), carril));
		return importe;
	}
	
	/**
	 * Este metodo retorna el importe total acumulado de todos los sensores del portico.
	 * @return el importe acumulado.
	 */
	public float getImporteAcumulado() {
		// TODO A completar
		float importeTotal = 0;
		for (Sensor sensor : sensores) {
			importeTotal += sensor.getImporteProcesados();
		}
		return importeTotal;
	}

	@Override
	public void mostrarEstadisticas() {
		System.out.println(String.format(MSG_PORTICO_ESTADISTICA, getNombre(), getImporteAcumulado()));
	}
}
	
	
	

