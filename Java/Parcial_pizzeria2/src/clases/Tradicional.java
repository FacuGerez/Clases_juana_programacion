package clases;

public class Tradicional extends Pizza {
	private static final String MSG_TRADICIONAL = "%-12s - %-15s - Precio de Venta: $%8.2f - %s\n";
	//TODO A completar
	private final TipoDeMasa tipoDeMasa;
	private final float costoBase;
	
	//TODO A completar
	public Tradicional(String nombre, float costoBase, float porcentajeGanancia, TipoDeMasa tipoDeMasa) {
		super(nombre, costoBase, porcentajeGanancia);
		this.costoBase = costoBase;
		this.tipoDeMasa = tipoDeMasa;
		this.tipoDePizza = TipoDePizza.TRADICIONAL;
		this.setCostoDeProduccion(getPrecioDeCosto());
	}

	@Override
	public float getPrecioDeCosto() {
		return costoBase * tipoDeMasa.getPorcentaje();
	}

	@Override
	public void mostrar() {
		System.out.printf(MSG_TRADICIONAL,"Tradicional",this.getNombre(),this.getPrecioDeVenta(),tipoDeMasa.getDescripcion());
	}

	//TODO A completar
	// Costo de produccion multiplicado por el porcentaje del tipo de masa.
	//
}
