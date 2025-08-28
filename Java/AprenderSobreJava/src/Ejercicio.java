import Cerveceria.*;

import static Cerveceria.Sabor.*;

public class Ejercicio {

	public static void main(String[] args) {
		Cervecera miCervecera = new Cervecera();
		
		System.out.println("El precio por litro es " + miCervecera.getPrecioLitro());
		System.out.println("El precio por unidad es " + miCervecera.getPrecioUnidad());
		
		miCervecera.agregarBarril(BOCK);
		miCervecera.agregarBarril(GOLDEN);
		miCervecera.agregarBarril(LAGER);
		miCervecera.agregarBarril(STOUT);
		miCervecera.agregarCajon(GOLDEN);
		miCervecera.agregarCajon(IPA);
		miCervecera.agregarCajon(LAGER);
		miCervecera.agregarCajon(BOCK);
		miCervecera.agregarCajon(STOUT);
		miCervecera.agregarCajon(HONEY);
		
		miCervecera.listarDisponibles();

		System.out.println("** VENTAS **");
		EnvaseCerveza cerveza = miCervecera.vender(Sabor.STOUT);
		mostrarCompra(cerveza);
		cerveza = miCervecera.vender(Medida.CHICA, BOCK);
		mostrarCompra(cerveza);
		cerveza = miCervecera.vender(Medida.MEDIANA, LAGER);
		mostrarCompra(cerveza);
		cerveza = miCervecera.vender(Medida.GRANDE, Sabor.IPA);
		mostrarCompra(cerveza);
		cerveza = miCervecera.vender(Medida.GRANDE, GOLDEN);
		mostrarCompra(cerveza);

		miCervecera.cerrarDia();
	}

	private static void mostrarCompra(EnvaseCerveza cerveza) {
		if (cerveza == null) {
			System.out.println("No habia cerveza del sabor pedido");
		} else {
			System.out.printf("%s de %s - %5.2f$\n", cerveza.getTipo(), cerveza.getSabor(), cerveza.getPrecioVenta());
		}
	}

}
