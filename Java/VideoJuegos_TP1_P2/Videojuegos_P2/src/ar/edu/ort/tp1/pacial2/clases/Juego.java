package ar.edu.ort.tp1.pacial2.clases;

public abstract class Juego implements Mostrable {

	private static final String MSG_GANANCIA_INVALIDA = "Ganancia invalida";
	private static final String MSG_PRECIO_INVALIDO = "Costo invalido";
	private static final String MSG_NOMBRE_INVALIDO = "Nombre invalido";
	private static final String MSG_TIPO_INVALIDO = "Tipo invalido";


	private String nombre;

	private float precioBase;

	private float porcentajeGanancia;

	private TipoDeJuego tipoDeJuego;

	private Cupon cupon;

	public Juego(String nombre, float precioBase, float porcentajeGanancia, Cupon cupon, TipoDeJuego tipoDeJuego) {
		// @TODO A completar
		setNombre(nombre);
		setPrecioBase(precioBase);
		setPorcentajeGanancia(porcentajeGanancia);
		setTipoDeJuego(tipoDeJuego);
		setCupon(cupon);
	}

	public String getNombre() {
		return nombre;
	}

	public float getPrecioBase() {
		return precioBase;
	}

	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	//VER
	public float getPrecioDeVenta() {
		float costo = this.getPrecioDeCosto();
		return costo + (this.porcentajeGanancia * costo / 100);
	}

	public abstract float getPrecioDeCosto();

	public abstract TipoJuego getTipoJuego();

	public TipoDeJuego getTipo() {
		return this.tipoDeJuego;
	}

	public Cupon getCupon() {
		return cupon;
	}

	public TipoDeJuego getTipoDeJuego() {
		return tipoDeJuego;
	}

	public void setCupon(Cupon cupon) {
		this.cupon = cupon;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException(MSG_NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}

	public void setPrecioBase(float precioBase) {
		if(precioBase <= 0) {
			throw new IllegalArgumentException(MSG_PRECIO_INVALIDO);
		}
		this.precioBase = precioBase;
	}

	public void setPorcentajeGanancia(float porcentajeGanancia) {
		if(porcentajeGanancia < 0) {
			throw new IllegalArgumentException(MSG_GANANCIA_INVALIDA);
		}
		this.porcentajeGanancia = porcentajeGanancia;
	}

	public void setTipoDeJuego(TipoDeJuego tipoDeJuego) {
		if(tipoDeJuego == null) {
			throw new IllegalArgumentException(MSG_TIPO_INVALIDO);
		}
		this.tipoDeJuego = tipoDeJuego;
	}
	
}
