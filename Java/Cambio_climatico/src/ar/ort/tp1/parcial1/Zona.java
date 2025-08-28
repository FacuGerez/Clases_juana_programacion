package ar.ort.tp1.parcial1;

import java.util.ArrayList;
import java.util.List;


public abstract class Zona implements Monitoreable{

	private int elevacion;
	private List<Double> temperaturas;
	private Coordenada coordenada;	

	public Zona(int elevacion, List<Double> temperaturas, Coordenada coordenada) {
		this.elevacion = elevacion;
		this.temperaturas = new ArrayList<>(temperaturas); // Arraylist copia, para encapsular las temps
		this.coordenada = coordenada;
	}

	protected int getElevacion() {
		return elevacion;
	}

	protected List<Double> getTemperaturas() {
		return temperaturas;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
}