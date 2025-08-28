package Cerveceria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Cervecera {

	private static final double PRECIO_BOTELLITA = 80.0;
	private static final double PRECIO_LITRO = 160.0;
	private ArrayList<Contenedor> deposito = new ArrayList<>();

	// DESCOMENTAR Y COMPLETAR
	private Refrigerador<Cajon> refrigeradorEnvasados = new Refrigerador<>();
	private Refrigerador<Barril> refrigeradorSueltos = new Refrigerador<>();
	
	
	// FALTAN ATRIBUTOS, COMPLETAR
	private ArrayList<Contador> peticiones_dia = new ArrayList<>(); //[]

	public Cervecera() {
		// completar
		for (Sabor sabor : Sabor.values()) {
			peticiones_dia.add(new Contador());// [Contador,contador,...]
		}
	}
	
	/**
	 * Guarda el barril en el refrigerador que corresponda.
	 * @param sabor
	 */
	public void agregarBarril(Sabor sabor) {
		refrigeradorSueltos.add(new Barril(sabor));
	}

	/**
	 * Guarda el cajon en el refrigerador que corresponda
	 * @param sabor
	 */
	public void agregarCajon(Sabor sabor) {
		refrigeradorEnvasados.add(new Cajon(sabor));
	}

	/**
	 * Se usa para vender botellitas. No olvides chequear el stock al terminar la venta.
	 * @param sabor
	 * @return
	 */
	public EnvaseCerveza vender(Sabor sabor) {
		EnvaseCerveza botellita = null;
		Cajon cajonConElSabor = refrigeradorEnvasados.buscar(sabor);
		if (cajonConElSabor != null) {
			botellita = cajonConElSabor.extraer();
			peticiones_dia.get((sabor.ordinal())).incrementar();
			if (cajonConElSabor.estaVacio()) {
				refrigeradorEnvasados.remove(cajonConElSabor);
				deposito.add(cajonConElSabor);
			}
		}
		return botellita;
	}

	/**
	 * Se usa para vender cerveza suelta en garrafas. No olvides chequear el stock al terminar la venta.
	 * @param capacidad
	 * @param sabor
	 * @return
	 */
	public EnvaseCerveza vender(Medida capacidad, Sabor sabor) {
		EnvaseCerveza envase = null;
		Barril barrilConElSabor = refrigeradorSueltos.buscar(sabor);
		if (barrilConElSabor != null) {
			envase = barrilConElSabor.extraer(capacidad);
			peticiones_dia.get((sabor.ordinal())).incrementar();
			if (barrilConElSabor.estaVacio()) {
				refrigeradorSueltos.remove(barrilConElSabor);
				deposito.add(barrilConElSabor);
			}
		}
		return envase;
	}

	/**
	 * Lista los sabores disponibles de cerveza suelta o preenvasada
	 */
	public void listarDisponibles() {
		HashSet<Sabor> saboresDisponibles = new HashSet<>(); // hashset = bolsa sin repetidos
		System.out.println("Sabores disponibles de cerveza envasada:");
		for (Cajon c : refrigeradorEnvasados.getLista()){
			saboresDisponibles.add(c.getSabor());
		}
		for (Sabor sabor : saboresDisponibles){
			System.out.println(sabor);
		}
		saboresDisponibles.clear();
		System.out.println("Sabores disponibles de cerveza suelta:");
		for (Barril b : refrigeradorSueltos.getLista()){
			saboresDisponibles.add(b.getSabor()); // (Heineken)
		}
		for (Sabor sabor : saboresDisponibles){
			System.out.println(sabor);
		}
	}

	public double getPrecioLitro() {
		return PRECIO_LITRO;
	}

	public double getPrecioUnidad() {
		return PRECIO_BOTELLITA;
	}

	/**
	 * Lista la reposicion a partir de lo que haya vacio en deposito.
	 */
	private void listarReposicion() {
		System.out.println("-- Reposiciones --");
		if (deposito.isEmpty()) {
			System.out.println("No hay nada que reponer.");
		} else {
			// completar
		}
	}

	/**
	 * Lista la cantidad de unidades vendidas de cada sabor.
	 */
	private void listarUnidadesVendidasPorSabor() {
		System.out.println("-- Unidades vendidas por sabor --");
		for (Sabor sabor : Sabor.values()){
			System.out.println(sabor + " = " + peticiones_dia.get(sabor.ordinal()).getValor());
			peticiones_dia.get(sabor.ordinal()).resetear();
		}
	}

	public void cerrarDia() {
		System.out.println("** Cierre del dia **");
		listarReposicion();
		listarUnidadesVendidasPorSabor();
	}

}