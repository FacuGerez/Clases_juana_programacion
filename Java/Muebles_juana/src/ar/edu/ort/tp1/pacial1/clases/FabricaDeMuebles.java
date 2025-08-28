package ar.edu.ort.tp1.pacial1.clases;

import java.util.ArrayList;

public class FabricaDeMuebles implements Mostrable {

	//TODO A completar
	private ArrayList<Mueble> muebles;
	private String nombre;
	
	private int mesas = 0;
	private int sillas = 0;
	private int sillones = 0;
	private float ventaTotal = 0;
	
	public FabricaDeMuebles(String nombre) {
		//TODO A completar
		setNombre(nombre);
		this.muebles = new ArrayList<>();
	}

	public ArrayList<Mueble> getMuebles() {
		return muebles;
	}

	public void setMuebles(ArrayList<Mueble> muebles) {
		this.muebles = muebles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean fabricar(Mueble m) {
		boolean retorno = false;
		//TODO A completar
		if(m != null) {
			retorno = true;
			if(m instanceof Mesa) {
				mesas++;
			}else if(m instanceof Silla) {
				sillas++;
			}else if(m instanceof Sillon) {
				sillones++;
			}
			this.muebles.add(m);
			m.mostrar();
			ventaTotal += m.calcularPrecioVenta();
		}
		return retorno;
	}

	@Override
	public void mostrar() {
		System.out.println("Fabrica de muebles: " +this.nombre+ this.muebles.size());
		System.out.println("Se han frabricado: " +mesas+ " Mesas, " +sillas+ " Sillas y " +sillones);
		System.out.println("La venta total fue: $ " +ventaTotal);
	}

	public boolean seHaFabricado(String modelo) {
		boolean seHaFabricado = false;
		//TODO A completar
		for (Mueble mueble : muebles) {
			if(mueble.getModelo().equals(modelo)) {
				seHaFabricado = true;
			}
		}
		return seHaFabricado;
	}
}
