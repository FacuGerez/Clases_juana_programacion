package ar.edu.ort.tp1.pacial2.clases;

public class JuegoEdicionEspecial extends Juego{

	private static final int AÑO = 1951;
	private static final String AÑO_INVALIDO = "El anio de lanzamiento no puede ser menor a 0";
	private static final float DESC_LANZAMIENTO = 15890.10f;
	
	private int anioLanzamiento;
	private ContenidoAdicional contenidoAdicional;
	
	public JuegoEdicionEspecial(String nombre, float costoBase, float porcentajeGanancia, int anioLanzamiento, ContenidoAdicional contenidoAdicional, Cupon cupon,
			TipoDeJuego tipoDeJuego) {
		super(nombre, costoBase, porcentajeGanancia, cupon, tipoDeJuego);
		setAnioLanzamiento(anioLanzamiento);
		setContenidoAdicional(contenidoAdicional);
	}

	public int getAnioLanzamiento() {
		return anioLanzamiento;
	}

	public void setAnioLanzamiento(int anioLanzamiento) {
		if(anioLanzamiento < AÑO) {
			throw new IllegalArgumentException(AÑO_INVALIDO);
		}
		this.anioLanzamiento = anioLanzamiento;
	}

	public ContenidoAdicional getContenidoAdicional() {
		return contenidoAdicional;
	}

	public void setContenidoAdicional(ContenidoAdicional contenidoAdicional) {
		this.contenidoAdicional = contenidoAdicional;
	}

	@Override
	public float getPrecioDeCosto() {
		//Seria solo poner la constante de DESC_LANZAMIENTO
		return this.getPrecioBase() + this.contenidoAdicional.getAdicional() - DESC_LANZAMIENTO/this.anioLanzamiento;
	}

	@Override
	public void mostrar() {
		System.out.println(this.getClass().getSimpleName()+ " - " +this.getNombre()+ " - Precio de Venta: $ " +this.getPrecioDeVenta()+ " - " +this.getAnioLanzamiento()+ " - " +this.getContenidoAdicional());
	}

	@Override
	public TipoJuego getTipoJuego() {
		return TipoJuego.EDICIONESPECIAL;
	}
}
