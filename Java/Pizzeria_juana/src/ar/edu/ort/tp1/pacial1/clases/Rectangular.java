package ar.edu.ort.tp1.pacial1.clases;

public class Rectangular extends Pizza {

	private static final String MSG_RECTANGULAR = "%-12s - %-15s - Precio de Venta: $%8.2f - %d porciones - %s\n";
	private static final float PRECIO_POR_PORCION = 45f;
	
	//TODO A completar
	private long ancho;
	private long largo;
	private AdicionalQueso adicionalQueso;

	//TODO A completar
	public Rectangular(String nombre, float costoBase, float porcentajeGanancia, long largo, long ancho, AdicionalQueso adicionalQueso) {
		super(nombre, costoBase, porcentajeGanancia);
		setAncho(ancho);
		setLargo(largo);
		setAdicionalQueso(adicionalQueso);
	}

	public long getAncho() {
		return ancho;
	}

	public void setAncho(long ancho) {
		this.ancho = ancho;
	}

	public long getLargo() {
		return largo;
	}

	public void setLargo(long largo) {
		this.largo = largo;
	}

	public AdicionalQueso getAdicionalQueso() {
		return adicionalQueso;
	}

	public void setAdicionalQueso(AdicionalQueso adicionalQueso) {
		this.adicionalQueso = adicionalQueso;
	}
	
	//TODO A completar
	// Costo de produccion + Precio de las porciones (ancho y largo) y todo eso 
	//	se multiplica por el adicional del queso.
	//
	@Override
	public float getPrecioDeCosto() {
		long porciones = this.ancho * this.largo;
		return (this.getCostoDeProduccion() + (porciones * PRECIO_POR_PORCION)) * this.adicionalQueso.getMultiplicadorQueso();
	}

	@Override
	public String tipo() {
		return "Rectangular";
	}
	
	@Override
	public void mostrar() {
		long porciones = this.ancho * this.largo;
		System.out.printf(MSG_RECTANGULAR, this.tipo(), this.getNombre(), this.getPrecioDeVenta(), porciones, this.adicionalQueso);
	}

}
