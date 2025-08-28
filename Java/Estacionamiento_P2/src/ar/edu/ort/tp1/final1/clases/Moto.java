package ar.edu.ort.tp1.final1.clases;

public class Moto extends Vehiculo{
    private final TipoMoto tipoMoto;

    public Moto(String patente, String marca, String modelo, TipoMoto tipoMoto) {
        super(patente, marca, modelo);
        this.tipoMoto = tipoMoto;
        this.setTipoVehiculo(TipoVehiculo.MOTO);
    }

    @Override
    public double costoPorHora() {
        return tipoMoto.getIndice();
    }
}
