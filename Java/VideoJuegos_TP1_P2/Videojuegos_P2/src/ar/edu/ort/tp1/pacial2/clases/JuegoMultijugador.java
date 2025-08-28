package ar.edu.ort.tp1.pacial2.clases;

public class JuegoMultijugador extends Juego{

	private static final String MSG_JUGADORES_INVALIDO = "Cantidad de jugadores invalida";
	private static final int PRECIO_JUGADOR = 45;
	
	private long cantidadJugadores;
	private ContenidoAdicional contenidoAdicional;
	
	public JuegoMultijugador(String nombre, float costoBase, float porcentajeGanancia, long cantidadJugadores, ContenidoAdicional contenidoAdicional, Cupon cupon,
			TipoDeJuego tipoDeJuego) {
		super(nombre, costoBase, porcentajeGanancia, cupon, tipoDeJuego);
		setCantidadJugadores(cantidadJugadores);
		setContenidoAdicional(contenidoAdicional);
	}

	public long getCantidadJugadores() {
		return cantidadJugadores;
	}

	public void setCantidadJugadores(long cantidadJugadores) {
		if(cantidadJugadores < 0) {
			throw new IllegalArgumentException(MSG_JUGADORES_INVALIDO);
		}
		this.cantidadJugadores = cantidadJugadores;
	}

	public ContenidoAdicional getContenidoAdicional() {
		return contenidoAdicional;
	}

	public void setContenidoAdicional(ContenidoAdicional contenidoAdicional) {
		this.contenidoAdicional = contenidoAdicional;
	}

	@Override
	public float getPrecioDeCosto() {
		return this.getPrecioBase() + PRECIO_JUGADOR * this.cantidadJugadores + this.contenidoAdicional.getAdicional();
	}

	@Override
	public void mostrar() {
		System.out.println(this.getClass().getSimpleName()+ " - " +this.getNombre()+ " - Precio de Venta: $ " +this.getPrecioDeVenta()+ " - " +this.getCantidadJugadores()+ " jugadores - " +this.getContenidoAdicional());
	}

	@Override
	public TipoJuego getTipoJuego() {
		return TipoJuego.MULTIJUGADOR;
	}
}
