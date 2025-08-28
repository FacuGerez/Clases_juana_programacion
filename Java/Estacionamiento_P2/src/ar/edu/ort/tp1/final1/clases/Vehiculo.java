package ar.edu.ort.tp1.final1.clases;

public abstract class Vehiculo implements Mostrable{

	private final String patente;
	private final String marca;
	private final String modelo;
	private TipoVehiculo tipoVehiculo;
	

	public Vehiculo(String patente, String marca, String modelo) {
		//TODO Completar
		if (patente == null || patente.isEmpty()){
			throw new IllegalArgumentException("La patente no puede ser nula ni vacia");
		}
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
	}

	@Override
	public void mostrar() {
		System.out.printf("Vehículo tipo: %s [patente=%s, marca=%s, modelo=%s]\n",tipoVehiculo.getDescripcion(), patente, marca, modelo);
	}

	public abstract double costoPorHora();

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public String getPatente() {
		return patente;
	}

	protected void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public boolean coincidePatente(String id) {
		return this.patente.equals(id);
	}

}
