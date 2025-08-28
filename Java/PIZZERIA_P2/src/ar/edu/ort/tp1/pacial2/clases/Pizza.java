package ar.edu.ort.tp1.pacial2.clases;

public abstract class Pizza implements Mostrable{

	private static final String MSG_GANANCIA_INVALIDA = "Ganancia inv�lida";
	private static final String MSG_COSTO_INVALIDO = "Costo inv�lido";
	private static final String MSG_NOMBRE_INVALIDO = "Nombre inv�lido";
	//TODO A completar
	private String nombre;
	private float costoDeProduccion;
	private float porcentajeGanancia;
	private Topping topping;

	public Pizza(String nombre, float costoDeProduccion, float porcentajeGanancia) {
		//TODO A completar
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException(MSG_NOMBRE_INVALIDO);
		}
		if (costoDeProduccion <= 0) {
			throw new IllegalArgumentException(MSG_COSTO_INVALIDO);
		}
		if (porcentajeGanancia < 0) {
			throw new IllegalArgumentException(MSG_GANANCIA_INVALIDA);
		}
		this.nombre = nombre;
		this.costoDeProduccion = costoDeProduccion;
		this.porcentajeGanancia = porcentajeGanancia;
	}

	public String getNombre() {
		return nombre;
	}

	public float getCostoDeProduccion() {
		return costoDeProduccion;
	}

	protected abstract Float getPrecioDeCosto();

	public Float getPrecioDeVenta(){
		return this.getPrecioDeCosto() + (this.getPrecioDeCosto() * this.porcentajeGanancia)/100;
	}

	public abstract TipoPizza getTipoPizza();
}
