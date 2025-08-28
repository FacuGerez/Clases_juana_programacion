package ar.edu.ort.tp1.pacial2.clases;

public class JuegoClasico extends Juego{

	private TipoDePlataforma tipoDePlataforma;

	public JuegoClasico(String nombre, float costoBase, float porcentajeGanancia, TipoDePlataforma tipoDePlataforma, Cupon cupon,
			TipoDeJuego tipoDeJuego) {
		super(nombre, costoBase, porcentajeGanancia, cupon, tipoDeJuego);
		setTipoDePlataforma(tipoDePlataforma);
	}

	public TipoDePlataforma getTipoDePlataforma() {
		return tipoDePlataforma;
	}

	public void setTipoDePlataforma(TipoDePlataforma tipoDePlataforma) {
		this.tipoDePlataforma = tipoDePlataforma;
	}

	@Override
	public float getPrecioDeCosto() {
		return this.getPrecioBase() * this.tipoDePlataforma.getMultiplicadorPlataforma();
	}

	@Override
	public void mostrar() {
		System.out.println(this.getClass().getSimpleName()+ " - " +this.getNombre()+ " - Precio de Venta: $ " +this.getPrecioDeVenta()+ " - " +this.tipoDePlataforma);
	}

	@Override
	public TipoJuego getTipoJuego() {
		return TipoJuego.CLASICO;
	}
}
