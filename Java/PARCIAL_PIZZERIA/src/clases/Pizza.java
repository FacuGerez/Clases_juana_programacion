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
		if (costoDeProduccion < 0){
			System.out.println(MSG_COSTO_INVALIDO);
			return;
		}
		if (porcentajeGanancia < 0){
			System.out.println(MSG_GANANCIA_INVALIDA);
			return;
		}
		if (nombre == null || nombre.isEmpty()){
			System.out.println(MSG_NOMBRE_INVALIDO);
			return;
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
		return costoDeProduccion + (porcentajeGanancia * costoDeProduccion);
	}


	public boolean modeloCorrecto(String modelo) {
		return modelo.equals(this.nombre);
	}

	public String getNombre() {
		return nombre;
	}
}
