package ar.edu.ort.tp1.final1.clases;

public interface EspacioInteligente<T, K> {

	T retirar(K id);
	void agregar(T elemento);
	int lugarDisponible();
}
