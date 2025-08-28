package ar.edu.ort.tp1.final1.clases;

public class AutoElectrico extends Auto{
    public AutoElectrico(String patente, String marca, String modelo, int cantPuertas) {
        super(patente, marca, modelo, 0, cantPuertas);
        this.setTipoVehiculo(TipoVehiculo.AUTO_ELECTRICO);
    }

    @Override
    public double costoPorHora() {
        return super.costoPorHora() - 1;
    }
}
