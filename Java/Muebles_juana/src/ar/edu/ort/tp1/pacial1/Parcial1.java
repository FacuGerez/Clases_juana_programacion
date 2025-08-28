package ar.edu.ort.tp1.pacial1;

import ar.edu.ort.tp1.pacial1.clases.FabricaDeMuebles;
import ar.edu.ort.tp1.pacial1.clases.MaterialSilla;
import ar.edu.ort.tp1.pacial1.clases.Mesa;
import ar.edu.ort.tp1.pacial1.clases.Silla;
import ar.edu.ort.tp1.pacial1.clases.Sillon;
import ar.edu.ort.tp1.pacial1.clases.TelaSillon;
import ar.edu.ort.tp1.pacial1.clases.TipoMesa;

public class Parcial1 {

	public static void main(String[] args) {

		FabricaDeMuebles fabrica = new FabricaDeMuebles("Super Fabrica 2000");

		fabrica.fabricar(new Silla("Silla 2", 230, 12, 22, MaterialSilla.MADERA));
		fabrica.fabricar(new Mesa("La Moderna 1", 1000, 24, 150, 70, TipoMesa.MODERNA));
		fabrica.fabricar(new Silla("Silla 3", 500, 8, 24, MaterialSilla.METAL));
		fabrica.fabricar(new Sillon("Sillon 1", 800, 15, 2, TelaSillon.PANA));
		fabrica.fabricar(new Silla("Silla 1", 200, 10, 20, MaterialSilla.PLASTICO));
		fabrica.fabricar(new Sillon("Sillon 2", 1000, 10, 1, TelaSillon.CHENILLE));
		fabrica.fabricar(new Sillon("Sillon 3", 1050, 20, 3, TelaSillon.GOBELINO));
		fabrica.fabricar(new Mesa("Nueva Moderna", 1200, 23, 150, 80, TipoMesa.MODERNA));
		fabrica.fabricar(new Sillon("Sillon 1.3", 800, 12, 3, TelaSillon.PANA));
		fabrica.fabricar(new Mesa("Gran Mesa Antigua", 2000, 22, 200, 80, TipoMesa.ANTIGUA));
		fabrica.fabricar(new Sillon("Sillon 4", 650, 25, 4, TelaSillon.GOBELINO));
		fabrica.fabricar(new Mesa("Gran Mesa Cristalina", 3000, 20, 100, 80, TipoMesa.CRISTAL));

		System.out.println("Se ha fabricado el modelo Silla 1?: " + (fabrica.seHaFabricado("Silla 1") ? "Si" : "No"));
		System.out.println("Se ha fabricado el modelo Silla 44?: " + (fabrica.seHaFabricado("Silla 44") ? "Si" : "No"));
		System.out.println("Se ha fabricado el modelo Gran Mesa Cristalina?: " + (fabrica.seHaFabricado("Gran Mesa Cristalina") ? "Si" : "No"));
		
		fabrica.mostrar();
	}

}
