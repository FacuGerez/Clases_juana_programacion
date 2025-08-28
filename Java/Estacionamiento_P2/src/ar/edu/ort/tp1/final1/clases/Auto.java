package ar.edu.ort.tp1.final1.clases;

public class Auto extends Vehiculo{
    private final int cilindradas;
    private final int cantPuertas;

    public Auto(String patente, String marca, String modelo, int cilindradas, int cantPuertas) {
        super(patente, marca, modelo);
        this.cilindradas = cilindradas;
        this.cantPuertas = cantPuertas;
        this.setTipoVehiculo(TipoVehiculo.AUTO);
    }

    @Override
    public double costoPorHora() {
        return cantPuertas + cilindradas;
    }
}
