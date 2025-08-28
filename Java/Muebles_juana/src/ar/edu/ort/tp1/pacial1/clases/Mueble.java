package ar.edu.ort.tp1.pacial1.clases;

public abstract class Mueble implements Mostrable {

	//TODO A completar
	private String modelo;
	private float costoBase;
	private float porcentajeGanancia;

	public Mueble(String modelo, float costoBase, float porcentajeGanancia) {
		//TODO A completar
		setModelo(modelo);
		setCostoBase(costoBase);
		setPorcentajeGanancia(porcentajeGanancia);
	}
	
	//TODO A completar M�todos
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}

	public void setCostoBase(float costoBase) {
		this.costoBase = costoBase;
	}

	public abstract float calcularPrecioCosto();
	
	public float calcularPrecioVenta() {
		//TODO A completar
		float costo = this.calcularPrecioCosto();
		return costo * (this.porcentajeGanancia * costo/100);
	}
	
	protected float getCostoBase() {
		return costoBase;
	}

	public boolean modeloCorrecto(String modelo) {
		return modelo == this.modelo;
	}

	@Override
	public void mostrar() {
		System.out.println("Fabricando el mueble:");
		System.out.println("Mueble tipo: " +this.getClass().getSimpleName()+ " - Modelo " +this.modelo+ " - Precio de venta: " +this.calcularPrecioVenta());
	}

}
