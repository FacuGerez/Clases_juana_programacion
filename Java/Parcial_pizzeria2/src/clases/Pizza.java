package clases;

public abstract class Pizza implements Mostrable {

	private static final String MSG_GANANCIA_INVALIDA = "Ganancia inv�lida";
	private static final String MSG_COSTO_INVALIDO = "Costo inv�lido";
	private static final String MSG_NOMBRE_INVALIDO = "Nombre inv�lido";
	//TODO A completar
	private String nombre;
	private float costoDeProduccion;
	private float porcentajeGanancia;
	protected TipoDePizza tipoDePizza;

	public TipoDePizza getTipoDePizza() {
		return tipoDePizza;
	}

	public Pizza(String nombre, float costoDeProduccion, float porcentajeGanancia) {
		if (costoDeProduccion <= 0){
			throw new IllegalArgumentException(MSG_COSTO_INVALIDO);
		}
		if (porcentajeGanancia <= 0){
			throw new IllegalArgumentException(MSG_GANANCIA_INVALIDA);
		}
		if (nombre == null || nombre.isEmpty()){
			throw new IllegalArgumentException(MSG_NOMBRE_INVALIDO);
		}
		//TODO A completar
		this.nombre = nombre;
		this.costoDeProduccion = costoDeProduccion;
		this.porcentajeGanancia = porcentajeGanancia;
	}

	//TODO A completar
	public abstract float getPrecioDeCosto();


	public float getPrecioDeVenta() {
		//TODO A completar
		return costoDeProduccion * ((porcentajeGanancia/100) + 1);
	}

	protected void setCostoDeProduccion(float costoDeProduccion) {
		this.costoDeProduccion = costoDeProduccion;
	}

	public boolean modeloCorrecto(String modelo) {
		return modelo.equals(this.nombre);
	}

	protected String getNombre() {
		return nombre;
	}
}
