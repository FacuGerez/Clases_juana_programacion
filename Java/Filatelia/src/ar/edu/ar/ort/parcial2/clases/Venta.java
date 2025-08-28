package ar.edu.ar.ort.parcial2.clases;

public class Venta implements Visualizable{
	
	private final Sello sello;
	private final int credencial;
	private final String contacto;
	
	public Venta(Sello s, int cred, String c) {
		if (s == null)throw new IllegalArgumentException(ERROR_SELLO);
		this.sello = s;
		this.credencial = cred; 
		this.contacto = c;
	}

	@Override
	public void verDatos() {
		System.out.printf("Sello: %s Comprador: %d Contacto: %s\n",sello.verDatos(),credencial,contacto);
	}
	//COMPLETAR metodos

	
	
}
