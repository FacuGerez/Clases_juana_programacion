package ar.edu.ort.tp1.parcial2.clases;

public class Titere extends Juguete {

    private static final String MSG_TAMANIO_INVALIDO = "Tamanio de titere invalido.";
    private static final String MSG_TITERE =
            "La titere cuesta %.2f tiene un tamanio de %d cm es de la marca %s y tiene un id %d\n";

    private int tamanio;

    public Titere(int id, String marca, int tamanio, float precio) {
        super(id, marca, precio);
        if (tamanio < 30 || tamanio > 70) {
            throw new IllegalArgumentException(MSG_TAMANIO_INVALIDO);
        }
        this.tamanio = tamanio;
    }

    @Override
    public void mostrar() {
        System.out.printf(MSG_TITERE, getPrecio(), tamanio, getMarca(), getId());
    }

    @Override
    public TipoDeJuguete getTipo() {
        return TipoDeJuguete.TITERE;
    }
}
