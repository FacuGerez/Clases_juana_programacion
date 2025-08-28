package Cerveceria;
public class Contador {
	private int valor;
	
	public Contador() {
		resetear();
	}
	
	public void incrementar() {
		valor++;
	}
	
	public int getValor() {
		return valor;
	}

	public void resetear() {
		valor = 0;
	}
}
