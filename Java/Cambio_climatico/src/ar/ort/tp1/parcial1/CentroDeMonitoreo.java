package ar.ort.tp1.parcial1;

import java.util.ArrayList;


public class CentroDeMonitoreo {
    private ArrayList<Zona> zonas;
    public CentroDeMonitoreo() {
        zonas = new ArrayList<>();
    }

    public void agregarUnaZona(Zona zona) {
        zonas.add(zona);
    }
    public double porcentajeDeZonasEnRiesgo() {
        double porcentaje = 0;
        for (Zona zona : zonas) {
            if (zona.enRiesgo()){
                porcentaje++;
            }
        }
        porcentaje = (porcentaje / zonas.size())*100;
        return porcentaje;
    }

    public void informarRiesgo(Coordenada coordenada) {
        Zona zona = null;
        for (Zona zona1 : zonas) {
            if (zona1.getCoordenada().coincideCon(coordenada)) {
                zona = zona1;
                break;
            }
        }
        if (zona == null) {
            System.out.println("No existe zona de coordenadas " + coordenada.toString());
            return;
        }
        String enRiesgoONo = zona.enRiesgo() ? "esta en risgo" : "no esta en risgo" ;
        System.out.println("La zona situada en " + coordenada.toString() + " " + enRiesgoONo );
    }
	
}