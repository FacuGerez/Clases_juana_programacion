package ar.edu.ort.tp1.pacial2.clases;

public class Tradicional extends Pizza {
    private TipoDeMasa tipoDeMasa;

    public Tradicional(String nombre, float costoDeProduccion, float porcentajeGanancia, TipoDeMasa tipoDeMasa) {
        super(nombre, costoDeProduccion, porcentajeGanancia);
        this.tipoDeMasa = tipoDeMasa;
    }

    @Override
    protected Float getPrecioDeCosto() {
        return getCostoDeProduccion() * tipoDeMasa.getPorcentaje();
    }

    @Override
    public void mostrar() {
        System.out.printf("%-12s - %-15s - Precio de Venta: $ %7.2f - %s\n",getTipoPizza().toString(),getNombre(),getPrecioDeVenta(),tipoDeMasa.getDescripcion());
    }

    @Override
    public TipoPizza getTipoPizza() {
        return TipoPizza.TRADICIONAL;
    }
}
