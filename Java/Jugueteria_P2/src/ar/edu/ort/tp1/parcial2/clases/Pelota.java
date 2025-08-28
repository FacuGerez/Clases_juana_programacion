package ar.edu.ort.tp1.parcial2.clases;

public class Pelota extends Juguete{

    private static final String LA_SUPERFICIE_NO_PUEDE_SER_NULA = "La superficie no puede ser nula";
    private static final String MSG_PELOTA = "La pelota cuesta %.2f pesos, es del tipo %s ademas es de la marca %s y tiene un id %d\n";

    private TipoDePelota deporte;

    public Pelota(int id, String marca, TipoDePelota deporte, float precio) {
        super(id, marca, precio);
        if (deporte == null) {
            throw new IllegalArgumentException(LA_SUPERFICIE_NO_PUEDE_SER_NULA);
        }
        this.deporte = deporte;
    }

    @Override
    public void mostrar() {
        System.out.printf(MSG_PELOTA, getPrecio(), deporte.getDescripcion(), getMarca(), getId());
    }

    @Override
    public TipoDeJuguete getTipo() {
        return TipoDeJuguete.PELOTA;
    }
}
