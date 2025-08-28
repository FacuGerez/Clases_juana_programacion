package tp1.ort.edu.ar.modelos;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControladorDeServicios implements Procesable {

	private static final String ERROR_MAXIMA_CANTIDAD_DE_SERVICIOS_ALCANZADA = "ERROR: Maxima cantidad de Servicios alcanzada";
	/**
	 * TODO Completar
	 */
	
	private static int contadorDeServicios;
    private static final int CANTIDAD_MAXIMA_SERVICIOS = 10;
	private ColaNodos<Servicio> servicios;
	private ColaNodos<Mensaje> mensajes;

	private HashMap<Integer,Integer[]> serviciosPorRespuesta;
	private ListaOrdenadaNodos<Integer, Servicio> serviciosPorDisponibilidad;

	public ControladorDeServicios() {
		servicios = new ColaNodos<>(CANTIDAD_MAXIMA_SERVICIOS);
		mensajes = new ColaNodos<>();
		contadorDeServicios = 0;
		serviciosPorRespuesta = new HashMap<>();
	}

	public void agregarServicio(String nombre, int prioridad, int cantidad, List<Prioridad> grupos) {
		try {
			Servicio nuevoServicio = new Servicio(nombre, cantidad, grupos);
			if (contadorDeServicios < CANTIDAD_MAXIMA_SERVICIOS) {
				servicios.add(nuevoServicio);
				serviciosPorRespuesta.put(nuevoServicio.getId(), new Integer[]{0,0});
				contadorDeServicios++;
				System.out.println(nuevoServicio.toString() + " agregado correctamente");
			} else {
				throw new IllegalArgumentException(ERROR_MAXIMA_CANTIDAD_DE_SERVICIOS_ALCANZADA);
			}
		} catch (Exception e) {
			System.out.println("Error al agregar: " + e.getMessage());
		}

	}

	public void agregarMensaje(Mensaje mensaje) {
		if (mensaje != null) {
			System.out.println(mensaje.toString() + " agregado");
			mensajes.add(mensaje);
		}
	}

	@Override
	public void procesar() {
		while (!mensajes.isEmpty()) {
			Mensaje msg = mensajes.remove();
			Servicio servicio = servicios.remove();
			Respuesta res = ejecutarMensaje(servicio, msg);
			if (res != null){
				System.out.printf("%s procesa msg %d resultado %s\n", servicio.getNombre(), msg.getId(), res);
				servicios.add(servicio);
                serviciosPorRespuesta.get(servicio.getId())[res.equals(Respuesta.OK) ? 0 : 1]++;
            }else{
				contadorDeServicios--;
			}
		}

	}

	private Respuesta ejecutarMensaje(Servicio servicio, Mensaje msg) {
		Respuesta res = null;
		try {
			res = servicio.consumir(msg);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	public void mostrarServiciosPorTipoDeRespuesta() {
		System.out.println("Servicios ----> OK ----> ERROR");
		for (Integer id : serviciosPorRespuesta.keySet()) {
			System.out.printf("Servicio ID: %d ---- %d ---- %d\n", id,serviciosPorRespuesta.get(id)[0],serviciosPorRespuesta.get(id)[1]);
		}
	}

	public void mostrarServiciosPorCantidadDeMensajes() {

		/**
		 * TODO Completar
		 */

	}

}
