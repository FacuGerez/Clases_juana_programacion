package ar.edu.ort.tp1.final1.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class Estacionamiento implements EspacioInteligente<Vehiculo, String>, Mostrable{

	private static final int CANTIDAD_PISOS_MIN = 2;
	private static final int CANTIDAD_VEHICULOS_MIN = 2;
	private final String nombre;
//	TODO COMPLETAR
	private final Piso[] pisos;
	private final ListaOrdenadaNodos<String, Moto> estacionamientoMotos;

	public Estacionamiento(String nombre, int cantPisos, int capacidadPiso) {
		this.nombre = nombre;
//		TODO COMPLETAR
		if (cantPisos < CANTIDAD_PISOS_MIN){
			throw new IllegalArgumentException("La cantidad de pisos debe ser mayor o igual a " + CANTIDAD_PISOS_MIN);
		}
		if (capacidadPiso < CANTIDAD_VEHICULOS_MIN){
			throw new IllegalArgumentException("La capacidad de piso debe ser mayor o igual a " + CANTIDAD_VEHICULOS_MIN);
		}
		pisos = new Piso[cantPisos];
		for (int i = 0; i < cantPisos; i++) {
			pisos[i] = new Piso(capacidadPiso);
		}
		estacionamientoMotos = new ListaMotosPorPatente();
	}

	@Override
	public Vehiculo retirar(String id) {
        for (Piso piso : pisos) {
            int repeticiones = piso.getCantidadVehiculos();
            for (int j = 0; j < repeticiones; j++) {
                Vehiculo vehiculo = piso.retirar(id);
                if (vehiculo.coincidePatente(id)) {
                    if (vehiculo.getTipoVehiculo() == TipoVehiculo.MOTO) {
                        estacionamientoMotos.removeByKey(id);
                    }
					System.out.println("El vehículo patente " + id + " estaba estacionado");
                    return vehiculo;
                }
                piso.agregar(vehiculo);
            }
        }
		System.out.println("El vehículo patente " + id + " no estaba estacionado");
		return null;
	}

	@Override
	public void agregar(Vehiculo elemento) {
		if (elemento.getTipoVehiculo() == TipoVehiculo.MOTO) {
			pisos[0].agregar(elemento);
			estacionamientoMotos.add((Moto) elemento);
		} else {
			for (int i = 1; i < pisos.length; i++) {
				if (pisos[i].lugarDisponible() > 0) {
					pisos[i].agregar(elemento);
					break;
				}
			}
		}
		System.out.println("Se agrego un");
		elemento.mostrar();
		System.out.printf("su índice de costo por hora es: %.2f\n", elemento.costoPorHora());
	}

	@Override
	public int lugarDisponible() {
		int total = 0;
		for (Piso piso : pisos) {
			total += piso.lugarDisponible();
		}
		return total;
	}

	@Override
	public void mostrar() {
		System.out.println("Estadísticas del garaje: " + nombre);
		System.out.println("Motos estacionadas por patente:");
		//TODO COMPLETAR
		for (Moto moto : estacionamientoMotos){
			moto.mostrar();
		}
	}
}
