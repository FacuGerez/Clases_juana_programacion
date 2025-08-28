package Cerveceria;
public abstract class EnvaseCerveza {

	private Sabor sabor;
	protected double precioVenta;

	public EnvaseCerveza(Sabor s) {
		sabor = s;
		this.precioVenta = 0;
	}

	public Sabor getSabor() {
		return sabor;
	}

	protected abstract void setPrecioVenta(double precio);

	public double getPrecioVenta() {
		return precioVenta;
	}

	public abstract String getTipo();
}
