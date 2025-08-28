package ar.edu.ort.tp1.peajes;

import ar.edu.ort.tp1.peajes.clases.Concesionaria;
import ar.edu.ort.tp1.peajes.clases.TipoDeAcoplado;
import ar.edu.ort.tp1.peajes.clases.Automovil;
import ar.edu.ort.tp1.peajes.clases.Camion;
import ar.edu.ort.tp1.peajes.clases.Motocicleta;
import ar.edu.ort.tp1.peajes.clases.Tractor;

public class Principal {

	public static void main(String[] args) {
		Concesionaria panamericana = new Concesionaria("Panamericana");
		
		System.out.println("\n--------------- AGREGANDO PORTICOS ---------------");
		agregarPorticos(panamericana, "Pilar");
		agregarPorticos(panamericana, "Ruta 197");
		agregarPorticos(panamericana, null);	// 
		agregarPorticos(panamericana, "Marquez");
		
		System.out.println("\n--------------- PROCESAR VEHICULOS ---------------");
		procesarVehiculos(panamericana);
		
		System.out.println("\n--------------- MOSTRAR ESTADISTICAS ---------------");
		panamericana.mostrarEstadisticas();
	}

	private static void agregarPorticos(Concesionaria concesionaria, String nombrePortico) {
		try {
			concesionaria.agregarPortico(nombrePortico);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void procesarVehiculos(Concesionaria concesionaria) {
		Automovil auto1 = new Automovil("CAR111", 2100);
		Automovil auto2 = new Automovil("CAR222", 2500);
		Motocicleta moto1 = new Motocicleta("A000", 1100, 350);
		Motocicleta moto2 = new Motocicleta("AAAA", 800, 150);
		Camion camion1 = new Camion("GGG GGG", 4500, TipoDeAcoplado.TANQUE);
		Camion camion2 = new Camion("YYY YYY", 4500, TipoDeAcoplado.PLATAFORMA);
		Camion camion3 = new Camion("YYY YYY", 4500, TipoDeAcoplado.PLATAFORMA);
		Tractor tractor = new Tractor("XXXXXX", 1);
	
		concesionaria.procesarVehiculo("Marquez"	, auto1, 1);
		concesionaria.procesarVehiculo("Pilar"		, auto1, 2);
		concesionaria.procesarVehiculo("Ruta 197"	, auto1, 1);
		concesionaria.procesarVehiculo("YYYYYYYYYY"	, moto1, 3);	// Portico invalido.
		concesionaria.procesarVehiculo("Marquez"	, auto2, 1);
		
		concesionaria.procesarVehiculo("Pilar"		, moto1, 3);
		concesionaria.procesarVehiculo("Ruta 197"	, moto1, 3);
		concesionaria.procesarVehiculo("XXXXXXXXXX"	, moto1, 3);	// Portico invalido.
		concesionaria.procesarVehiculo("Ruta 197"	, moto2, 2);
		concesionaria.procesarVehiculo("Marquez"	, moto2, 1);
		concesionaria.procesarVehiculo("Ruta 197"	, tractor, 1);	// Vehiculo No soportado.
		
		
		concesionaria.procesarVehiculo("Ruta 197"	, camion1, 2);
		concesionaria.procesarVehiculo("Marquez"	, camion1, 1);
		concesionaria.procesarVehiculo("Marquez"	, camion2, 1);
		concesionaria.procesarVehiculo("Marquez"	, camion3, 1);
		
		concesionaria.procesarVehiculo("Marquez"	, camion3, 15); // Carril invalido.
		
		concesionaria.procesarVehiculo("Marquez"	, tractor, 1);	// Vehiculo No soportado.
		
	}

}
