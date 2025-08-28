package ar.edu.ort.tp1.parcial2.clases;

public abstract class Juguete implements Mostrable{
    private static final String MSG_MARCA_INVALIDA = "La marca no puede ser nula ni vacia";
    private static final String MSG_ID_INVALIDO = "El id no puede ser menor a 1";

    private int id;
    private String marca;
    private float precio;

    public Juguete(int id, String marca, float precio) {
        if (id < 1) {
            throw new IllegalArgumentException(MSG_ID_INVALIDO);
        }
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException(MSG_MARCA_INVALIDA);
        }
        if (precio < 1) {
            throw new IllegalArgumentException("El precio no puede ser menor a 1");
        }
        this.id = id;
        this.marca = marca;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public float getPrecio() {
        return precio;
    }

    public abstract TipoDeJuguete getTipo();
}