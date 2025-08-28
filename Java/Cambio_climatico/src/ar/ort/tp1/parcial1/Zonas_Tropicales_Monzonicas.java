package ar.ort.tp1.parcial1;

import java.util.List;

public class Zonas_Tropicales_Monzonicas extends Zonas_Tropicales{
    private IntensidadViento intensidad;

    public Zonas_Tropicales_Monzonicas(int elevacion, List<Double> temperaturas, Coordenada coordenada, int mmLlovidos, IntensidadViento intensidad) {
        super(elevacion, temperaturas, coordenada, mmLlovidos);
        this.intensidad = intensidad;
    }

    @Override
    public boolean enRiesgo() {
        List<Double> temperaturas = super.getTemperaturas();
        for (double temperatura : temperaturas) {
            if (temperatura <= 15 && intensidad == IntensidadViento.LEVE){
                return true;
            }
        }
        return super.enRiesgo();
    }
}
