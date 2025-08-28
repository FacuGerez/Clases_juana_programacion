package ar.edu.ort.tp1.pacial1.clases;

public abstract class Pizza implements Mostrable {

	private static final String MSG_GANANCIA_INVALIDA = "Ganancia inv�lida";
	private static final String MSG_COSTO_INVALIDO = "Costo inv�lido";
	private static final String MSG_NOMBRE_INVALIDO = "Nombre inv�lido";
	
	//TODO A completar
	private String nombre;
	private float costoDeProduccion;
	private float porcentajeGanancia;
	
	public Pizza(String nombre, float costoDeProduccion, float porcentajeGanancia) {
		setNombre(nombre);
		setCostoDeProduccion(costoDeProduccion);
		setPorcentajeGanancia(porcentajeGanancia);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException(MSG_NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}

	public float getCostoDeProduccion() {
		return costoDeProduccion;
	}

	public void setCostoDeProduccion(float costoDeProduccion) {
		if(costoDeProduccion <= 0) {
			throw new IllegalArgumentException(MSG_COSTO_INVALIDO);
		}
		this.costoDeProduccion = costoDeProduccion;
	}

	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(float porcentajeGanancia) {
		if(porcentajeGanancia < 0) {
			throw new IllegalArgumentException(MSG_GANANCIA_INVALIDA);
		}
		this.porcentajeGanancia = porcentajeGanancia;
	}

	//TODO A completar
	public abstract float getPrecioDeCosto();
	
	public abstract String tipo();

	public float getPrecioDeVenta() {
		//TODO A completar
		float costo = this.getPrecioDeCosto();
		return costo + (this.porcentajeGanancia * costo/100);
	}

	public boolean modeloCorrecto(String modelo) {
		return modelo == this.nombre;
	}

}
