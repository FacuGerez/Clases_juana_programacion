package ar.edu.ort.tp1.parcial2.clases;

public interface ContenedorInteligente<T, K> {
    /**
     * Agrega un elemento al deposito.
     * @param t elemento a depositar
     */
    public void guardar(T elemento);

    /**
     * Recupera un elemento del contenedor en base a su ID
     * @param id
     * @return
     */
    public T recuperarPorId(K id);
}
