package ar.edu.ar.ort.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;

import java.util.ArrayList;

public class CentroDeCompilacion implements Visualizable{

	private final ArrayList<Integer> sellosPorImpresion = new ArrayList<>();
	private final ListaOrdenadaSellos listaOrdenada = new ListaOrdenadaSellos();
	private final PilaNodos<Venta> ventasRealizadas = new PilaNodos<>();
	private final double[][] matriz;

	public CentroDeCompilacion() {
		for (Impresion _ : Impresion.values()) {
			sellosPorImpresion.add(0);
		}
		matriz = new double[Impresion.values().length][Formato.values().length];
		for (Impresion imp : Impresion.values()) {
			for (Formato form : Formato.values()) {
				matriz[imp.ordinal()][form.ordinal()] = 0;
			}
		}
	}


	public void agregarSellos(Sello sello) {
		listaOrdenada.add(sello);
	}

	@Override
	public void verDatos() {
		System.out.println("Sellos sin vender");
		System.out.println("-----------------------------------------------------");
		for (Sello sello : listaOrdenada) {
			System.out.printf(INFO_SELLO,sello.toString(),sello.verDatos(),sello.calcularValorSello());
		}
		System.out.println("-----------------------------------------------------");
		System.out.println("Ventas efectuadas con éxito");
		System.out.println("-----------------------------------------------------");
		while (!ventasRealizadas.isEmpty()){
			ventasRealizadas.pop().verDatos();
		}
		System.out.println("-----------------------------------------------------");
		System.out.printf(MSG_TIPO_IMPRESION, sellosPorImpresion.get(Impresion.HUECOGRABADO.ordinal()),sellosPorImpresion.get(Impresion.LITOGRAFÍA.ordinal()), sellosPorImpresion.get(Impresion.TIPOGRAFÍA.ordinal()),sellosPorImpresion.get(Impresion.FOTOGRABADO.ordinal()), sellosPorImpresion.get(Impresion.TROQUELADO.ordinal()));
		System.out.println("-----------------------------------------------------");
		double recaudado = calcularRecaudacion(matriz);
		System.out.printf(MSG_RECAUDACION_TOTAL,recaudado);
		System.out.println("-----------------------------------------------------");
		System.out.println(verificarRecaudacion(recaudado));
	}

	public void realizarVentaSello(String pie, int cred, String contacto) {
		Sello paraVender = null;
        for (Sello sello : listaOrdenada) {
            if (sello.getPieDeimprenta().equals(pie)) {
                paraVender = sello;
            }
        }


		Venta venta = new Venta(paraVender, cred, contacto);
		listaOrdenada.remove(paraVender);
		Integer ventas = sellosPorImpresion.get(paraVender.getTipoDeImpresion().ordinal());
		ventas++;
		sellosPorImpresion.set(paraVender.getTipoDeImpresion().ordinal(), ventas);
		ventasRealizadas.push(venta);
		matriz[paraVender.getTipoDeImpresion().ordinal()][paraVender.getFormato().ordinal()] += paraVender.calcularValorSello();
	}
	
	
	
	private double calcularRecaudacion(double [][] ventas) {
		double recaudado = 0;
        for (double[] venta : ventas) {
            for (double v : venta) {
                recaudado += v;
            }
        }
		return recaudado;
	}
	
	private String verificarRecaudacion(double recaudacion) {
		RangoNumeros rango = new RangoNumeros(25,35);
		return rango.incluye((float)recaudacion) ? MSG_VENTAS_CRITICAS : "";
	}
}
	

