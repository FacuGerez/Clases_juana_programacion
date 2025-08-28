package ar.edu.ort.tp1.pacial2.clases;

public class Especial extends Pizza {
    private static final int PRECIOUNITARIOFAINA = 70;
    private TamanioDePizza tamanio;
    private Integer cantidadDeFaina;

    public Especial(String nombre, float costoDeProduccion, float porcentajeGanancia, Integer cantidadDeFaina, TamanioDePizza tamanio) {
        super(nombre, costoDeProduccion, porcentajeGanancia);
        this.tamanio = tamanio;
        this.cantidadDeFaina = cantidadDeFaina;
    }

    @Override
    protected Float getPrecioDeCosto() {
        return (getCostoDeProduccion() * tamanio.getPorcentaje()) + (cantidadDeFaina * PRECIOUNITARIOFAINA);
    }

    @Override
    public void mostrar() {
        System.out.printf("%-12s - %-15s - Precio de Venta: $ %7.2f - %d fainas - %s\n",getTipoPizza().toString(),getNombre(),getPrecioDeVenta(),cantidadDeFaina,tamanio.getDescripcion());
    }

    @Override
    public TipoPizza getTipoPizza() {
        return TipoPizza.ESPECIAL;
    }
}
