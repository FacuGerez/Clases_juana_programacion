package clases;

public class Especial extends Pizza {
	private static final String MSG_ESPECIAL = "%-12s - %-15s - Precio de Venta: $%8.2f - %d fainas - %s\n";
	private static final float PRECIO_UNITARIO_FAINA = 70f;
	//TODO A completar
	private final float costoBase;
	private final int cantidadFainas;
	private final TamanioDePizza tamanioDePizza;

	//TODO A completar
	public Especial(String nombre, float costoBase, float porcentajeGanancia, int cantidadFainas, TamanioDePizza tamanioDePizza) {
		super(nombre,(costoBase * tamanioDePizza.getPorcentaje()) + (cantidadFainas * PRECIO_UNITARIO_FAINA),porcentajeGanancia);
		this.costoBase = costoBase;
		this.cantidadFainas = cantidadFainas;
		this.tamanioDePizza = tamanioDePizza;
		this.tipoDePizza = TipoDePizza.ESPECIAL;
	}

	@Override
	public float getPrecioDeCosto() {
		return (costoBase * tamanioDePizza.getPorcentaje()) + (cantidadFainas * PRECIO_UNITARIO_FAINA);
	}

	@Override
	public void mostrar() {
		System.out.printf(MSG_ESPECIAL,"Especial", this.getNombre(), this.getPrecioDeVenta(), cantidadFainas,tamanioDePizza.getDescripcion());
	}
//TODO A completar
	// Costo de produccion * el porcentaje del tama�o. 
	//	A todo eso se le suma las cantidades de Faina por el precio unitario de cada faina.
	//

}
