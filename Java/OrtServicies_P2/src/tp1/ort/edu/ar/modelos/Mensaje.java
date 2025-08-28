package tp1.ort.edu.ar.modelos;

public abstract class Mensaje implements Ejecutable {

	/**
	 * TODO Completar
	 */
	private static int contador = 0;
	private int id;
	private Prioridad prioridad;

	public Mensaje(Prioridad prioridad) {
		if (prioridad == null){
			throw new IllegalArgumentException("Prioridad Nula");
		}
		id = contador;
		contador++;
		this.prioridad = prioridad;
	}

	public int getId() {
		return id;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public String toString() {
		return String.format("Mensaje [id=%d, prioridad=%s]", id, prioridad);
	}
}
