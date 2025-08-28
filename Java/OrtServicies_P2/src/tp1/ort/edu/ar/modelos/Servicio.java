package tp1.ort.edu.ar.modelos;

import java.util.ArrayList;
import java.util.List;

public class Servicio implements Consumible, Identificable {

	private static final String CANTIDAD_DE_SERVICIO_INVALIDO = "Cantidad De Servicio Invalido";
	private static final String NOMBRE_DE_SERVICIO_INVALIDO = "Nombre De Servicio Invalido";
	private static final String CANTIDAD_MAXIMA_DE_MENSAJES_CONSUMIDOS_ALCANZADA = "Cantidad Maxima de Mensajes consumidos alcanzada!";
	private static final String MSG_PROCESAMIENTO_RESULTADO = "%s procesa msg %s resultado %s %n";
	
	/**
	 * TODO Completar
	 */
	private static int contador = 0;
	private int cantidadMensajesConsumidos;
	private String nombre;
	private int cantidad;
	private List<Prioridad> grupos;
	private int id;

	public Servicio(String nombre, int cantidad, List<Prioridad> lista) {
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException(NOMBRE_DE_SERVICIO_INVALIDO);
		}
		if (cantidad < 0 || cantidad > 1000) {
			throw new IllegalArgumentException(CANTIDAD_DE_SERVICIO_INVALIDO);
		}
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.grupos = lista;
		this.id = contador;
		this.cantidadMensajesConsumidos = 0;
		contador++;
	}

	
	public Respuesta consumir(Mensaje mensaje) throws RuntimeException {
		if (cantidadMensajesConsumidos <= cantidad) {
			cantidadMensajesConsumidos++;
			return mensaje.ejecutar(this);
		} else {
			throw new RuntimeException(CANTIDAD_MAXIMA_DE_MENSAJES_CONSUMIDOS_ALCANZADA);
		}
	}

	public boolean puedeServicio(Prioridad prioridad) {
		return grupos != null ? grupos.contains(prioridad) : true;
	}

	public String toString() {
		return String.format("Servicio [nombre=%s, mensajesConsumidos=%d, cantidadMaximaMensajes=%d, id=%d]",nombre, cantidadMensajesConsumidos, cantidad, id);
	}

	public int disponibilidad() {
		return cantidad - cantidadMensajesConsumidos;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public boolean sameId(int id) {
		return id == this.id;
	}

	public String getNombre() {
		return nombre;
	}
}
