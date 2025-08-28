package ar.ort.tp1.parcial1;

import java.util.Arrays;
import java.util.List;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public class Principal {

	public static void main(String[] args) {
		// No hay nada que hacer aquí en el main...
		CentroDeMonitoreo centro = new CentroDeMonitoreo();
		
		agregarZonasDePrueba(centro);
		testearPorcentajeDeZonasEnRiesgo(centro);
		System.out.println("------------------");
		testearInformarRiesgo(centro);
	}
	
	private static void agregarZonasDePrueba (CentroDeMonitoreo centro) {
		List<Double> temps1 = Arrays.asList(47.3, 45.2, 40.1, 46.8, 39.6, 48.0, 49.8);
		List<Double> temps2 = Arrays.asList(35.5, 36.2, 34.8, 33.9, 35.7, 36.5);
		List<Double> temps3 = Arrays.asList(28.7, 29.2, 30.5, 31.1, 29.8, 30.0, 28.3, 32.0, 28.9);
		List<Double> temps4 = Arrays.asList(55.6, 54.8, 56.2, 57.3, 55.9);
		List<Double> temps5 = Arrays.asList(15.2, 15.5, 15.3, 15.7, 15.1, 14.9, 15.5);
		List<Double> temps6 = Arrays.asList(15.8, 15.3, 15.6, 15.7, 15.2, 15.8, 15.1);

		/*
		 *  TODO Usá las temperaturas anteriores para crear aquí las
		 *  zonas que pide el enunciado y agregarlas al centro
		 */
		centro.agregarUnaZona(new Zonas_Secas(2700,temps1,new Coordenada(3,4),87));
		centro.agregarUnaZona(new Zonas_Tropicales(1350,temps2,new Coordenada(0,2),256));
		centro.agregarUnaZona(new Zonas_Tropicales(900,temps3,new Coordenada(9,-6),212));
		centro.agregarUnaZona(new Zonas_Secas(3100,temps4,new Coordenada(-2,7),92));
		centro.agregarUnaZona(new Zonas_Tropicales_Monzonicas(2100,temps5,new Coordenada(4,0),110,IntensidadViento.LEVE));
		centro.agregarUnaZona(new Zonas_Tropicales_Monzonicas(1900,temps6,new Coordenada(5,5),115,IntensidadViento.LEVE));
	}
	
	private static void testearPorcentajeDeZonasEnRiesgo (CentroDeMonitoreo centro) {
		// TODO Descomentar y completar
		System.out.println("Porcentaje de zonas en riesgo: " + centro.porcentajeDeZonasEnRiesgo() + "%");
	}
	
	private static void testearInformarRiesgo (CentroDeMonitoreo centro) {	
		// No hay nada que hacer aquí...
		centro.informarRiesgo(new Coordenada(3,4));
		centro.informarRiesgo(new Coordenada(0,2));
		centro.informarRiesgo(new Coordenada(9,-6));
		centro.informarRiesgo(new Coordenada(-2,7));
		centro.informarRiesgo(new Coordenada(4,0));
		centro.informarRiesgo(new Coordenada(5,5));
		centro.informarRiesgo(new Coordenada(0,0));
	}

}