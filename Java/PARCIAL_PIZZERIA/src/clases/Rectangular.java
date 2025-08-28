package clases;

public class Rectangular extends Pizza {

	private static final String MSG_RECTANGULAR = "%-12s - %-15s - Precio de Venta: $%8.2f - %d porciones - %s\n";
	private static final float PRECIO_POR_PORCION = 45f;
	//TODO A completar
	private final long largo;
	private final long ancho;
	private final AdicionalQueso adicionalQueso;
	private final float costoBase;

	//TODO A completar
	public Rectangular(String nombre, float costoBase, float porcentajeGanancia, long largo, long ancho, AdicionalQueso adicionalQueso) {
		super(nombre,(costoBase + ((largo * ancho) * PRECIO_POR_PORCION)) * adicionalQueso.getMultiplicadorQueso(),porcentajeGanancia);
		this.largo = largo;
		this.ancho = ancho;
		this.adicionalQueso = adicionalQueso;
		this.costoBase = costoBase;
		this.tipoDePizza = TipoDePizza.RECTANGULAR;
	}

	//TODO A completar

	@Override
	public float getPrecioDeCosto() {
		return (costoBase + ((largo * ancho) * PRECIO_POR_PORCION)) * adicionalQueso.getMultiplicadorQueso();
	}

	@Override
	public void mostrar() {
		System.out.printf(MSG_RECTANGULAR,"Rectangular",this.getNombre(),this.getPrecioDeVenta(),(largo * ancho),adicionalQueso.getDescripcion());
	}
	// Costo de produccion + Precio de las porciones (ancho y largo) y todo eso 
	//	se multiplica por el adicional del queso.
	//
}
