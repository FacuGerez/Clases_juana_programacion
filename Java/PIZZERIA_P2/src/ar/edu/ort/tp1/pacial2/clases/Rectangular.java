package ar.edu.ort.tp1.pacial2.clases;

public class Rectangular extends Pizza {
    private static final float PRECIOUNITARIOPORCION = 45;
    private long largo;
    private long ancho;
    private AdicionalQueso adicionalQueso;

    public Rectangular(String nombre, float costoDeProduccion, float porcentajeGanancia, long largo, long ancho, AdicionalQueso adicionalQueso) {
        super(nombre, costoDeProduccion, porcentajeGanancia);
        this.largo = largo;
        this.ancho = ancho;
        this.adicionalQueso = adicionalQueso;
    }

    @Override
    protected Float getPrecioDeCosto() {
        return (getCostoDeProduccion()+((largo*ancho)*PRECIOUNITARIOPORCION))*adicionalQueso.getMultiplicadorQueso();
    }

    @Override
    public void mostrar() {
        System.out.printf("%-12s - %-15s - Precio de Venta: $ %7.2f - %d porciones - %s\n",getTipoPizza().toString(),getNombre(),getPrecioDeVenta(),largo*ancho,adicionalQueso.getDescripcion());
    }

    @Override
    public TipoPizza getTipoPizza() {
        return TipoPizza.RECTANGULAR;
    }
}
