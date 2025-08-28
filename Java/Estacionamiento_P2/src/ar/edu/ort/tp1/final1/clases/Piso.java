package ar.edu.ort.tp1.final1.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;

public class Piso implements EspacioInteligente<Vehiculo, String>{

	private static final int MINIMA_CAPACIDAD_MAXIMA = 2;
//	TODO COMPLETAR
	private final ColaNodos<Vehiculo> estacionamiento;
	private final int capacidadMaxima;
	private int cantidadVehiculos;
	
	public Piso(int capacidadMaxima) {
//		TODO COMPLETAR
		this.capacidadMaxima = capacidadMaxima;
		estacionamiento = new ColaNodos<>(capacidadMaxima);
		cantidadVehiculos = 0;
	}

	@Override
	public Vehiculo retirar(String id) {
		if (estacionamiento.isEmpty()) {
			return null;
		}else {
			Vehiculo vehiculo = estacionamiento.remove();
			cantidadVehiculos--;
			return vehiculo;
		}
	}

	@Override
	public void agregar(Vehiculo elemento) {
		if (estacionamiento.isFull()) {
			throw new RuntimeException("El estacionamiento está lleno");
		}
		estacionamiento.add(elemento);
		cantidadVehiculos++;
	}

	@Override
	public int lugarDisponible() {
		return capacidadMaxima - cantidadVehiculos;
	}

	public int getCantidadVehiculos() {
		return cantidadVehiculos;
	}
}
