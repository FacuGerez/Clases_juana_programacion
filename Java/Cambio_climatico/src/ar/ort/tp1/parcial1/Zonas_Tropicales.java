package ar.ort.tp1.parcial1;

import java.util.List;

public class Zonas_Tropicales extends Zona{
    private int mmLlovidos;

    public Zonas_Tropicales(int elevacion, List<Double> temperaturas, Coordenada coordenada, int mmLlovidos) {
        super(elevacion, temperaturas, coordenada);
        this.mmLlovidos = mmLlovidos;
    }

    @Override
    public boolean enRiesgo() {
        return mmLlovidos>= 200 && super.getElevacion() <= 1000;
    }
}
