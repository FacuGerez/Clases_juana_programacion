package ar.edu.ort.tp1.pacial1.clases;

public class Tradicional extends Pizza {
	
	private static final String MSG_TRADICIONAL = "%-12s - %-15s - Precio de Venta: $%8.2f - %s\n";
	
	//TODO A completar
	private TipoDeMasa tipoDeMasa;
	
	//TODO A completar
	public Tradicional(String nombre, float costoBase, float porcentajeGanancia, TipoDeMasa tipoDeMasa) {
		super(nombre, costoBase, porcentajeGanancia);
		setTipoDeMasa(tipoDeMasa);
	}

	public TipoDeMasa getTipoDeMasa() {
		return tipoDeMasa;
	}

	public void setTipoDeMasa(TipoDeMasa tipoDeMasa) {
		this.tipoDeMasa = tipoDeMasa;
	}

	//TODO A completar
	// Costo de produccion multiplicado por el porcentaje del tipo de masa.
	//
	@Override
	public float getPrecioDeCosto() {
		return this.getCostoDeProduccion() * this.tipoDeMasa.getPorcentaje();
	}

	@Override
	public String tipo() {
		return "Tradicional";
	}
	
	@Override
	public void mostrar() {
		System.out.printf(MSG_TRADICIONAL, this.tipo(), this.getNombre(), this.getPrecioDeVenta(), this.tipoDeMasa);
	}
	
}
