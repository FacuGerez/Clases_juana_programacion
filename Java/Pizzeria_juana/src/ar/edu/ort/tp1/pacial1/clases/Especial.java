package ar.edu.ort.tp1.pacial1.clases;

public class Especial extends Pizza {
	
	private static final String MSG_ESPECIAL = "%-12s - %-15s - Precio de Venta: $%8.2f - %d fainas - %s\n";
	private static final float PRECIO_UNITARIO_FAINA = 70f;
	
	//TODO A completar
	private int cantidadFainas;
	private TamanioDePizza tamanioDePizza;
	
	//TODO A completar
	public Especial(String nombre, float costoBase, float porcentajeGanancia, int cantidadFainas, TamanioDePizza tamanioDePizza) {
		super(nombre, costoBase, porcentajeGanancia);
		setCantidadFainas(cantidadFainas);
		setTamanioDePizza(tamanioDePizza);
	}

	public int getCantidadFainas() {
		return cantidadFainas;
	}

	public void setCantidadFainas(int cantidadFainas) {
		this.cantidadFainas = cantidadFainas;
	}

	public TamanioDePizza getTamanioDePizza() {
		return tamanioDePizza;
	}

	public void setTamanioDePizza(TamanioDePizza tamanioDePizza) {
		this.tamanioDePizza = tamanioDePizza;
	}

	//TODO A completar
	// Costo de produccion * el porcentaje del tama�o. 
	//	A todo eso se le suma las cantidades de Faina por el precio unitario de cada faina.
	//
	@Override
	public float getPrecioDeCosto() {
		return (this.getCostoDeProduccion() * this.tamanioDePizza.getPorcentaje()) + (this.cantidadFainas * PRECIO_UNITARIO_FAINA);
	}

	@Override
	public String tipo() {
		return "Especial";
	}
	
	@Override
	public void mostrar() {
		System.out.printf(MSG_ESPECIAL, this.tipo(), this.getNombre(), this.getPrecioDeVenta(), this.cantidadFainas, this.tamanioDePizza);
	}

}
