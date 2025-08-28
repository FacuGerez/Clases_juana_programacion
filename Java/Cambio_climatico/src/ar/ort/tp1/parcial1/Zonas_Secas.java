package ar.ort.tp1.parcial1;

import java.util.List;

public class Zonas_Secas extends Zona{
    private double porcentajeDeInsolacion;

    public Zonas_Secas(int elevacion, List<Double> temperaturas, Coordenada coordenada, double porcentajeDeInsolacion) {
        super(elevacion, temperaturas, coordenada);
        this.porcentajeDeInsolacion = porcentajeDeInsolacion;
    }

    @Override
    public boolean enRiesgo() {
        List<Double> temperaturas = super.getTemperaturas();
        double promedio = 0;
        for (double temperatura : temperaturas) {
            promedio += temperatura;
        }
        promedio = promedio / temperaturas.size();
        return promedio >= 43 && porcentajeDeInsolacion <= 90;
    }
}
