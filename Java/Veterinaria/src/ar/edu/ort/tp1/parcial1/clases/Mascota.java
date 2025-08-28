package ar.edu.ort.tp1.parcial1.clases;

public abstract class Mascota implements Animal {

	private static final String MSG_COM_FELIZ = " dice: He comido demasiado";
	private static final String MSG_COM_HAMBRIENTO = " dice: Muchas gracias ten�a hambre";
	private static final String MSG_COM_ENFERMO = " dice: No ten�a mucha hambre, pero gracias";

	private static final int CIEN = 100;
	private String nombre;
	private double peso;
	private boolean vacunado;
	private Estado estado;

	public Mascota(String nombre, double peso, boolean vacunado, Estado estado) {
		this.nombre = nombre;
		this.peso = peso;
		this.vacunado = vacunado;
		this.estado = estado;
	}
// TODO Completar

	// TODO Completar
	/**
	 * Alimenta a las mascotas de forma general. Si su estado es hambiento estar�
	 * feliz y dara las gracias ya que ten�a hambre Si su estado es feliz, se
	 * enfermar� e indicar� que comio demasiado. si estaba enfermo, dara las gracias, pero seguir� enfermo.
	 * adem�s actualizar� el peso sumando al actual la multiplicaci�n entre la cantidad de comida recibida y un multiplicador.
	 * Finalmente indicar� su estado
	 *
	 * param comida
	 * param multiplicador
	 */

	public String getNombre() {
		return nombre;
	}

	public void actualizarPeso(double porcentaje) {
		this.peso += peso * porcentaje / CIEN;
	}

	public boolean esVacunado() {
		return vacunado;
	}

	public void vacunar() {
		vacunado = true;
	}
	protected abstract double getPorcentaje();

	protected void comer(double comida, double multiplicador){
		switch (estado) {
			case FELIZ -> {
				System.out.println(MSG_COM_FELIZ);
				estado = Estado.ENFERMO;
			}
			case HAMBRIENTO -> {
				System.out.println(MSG_COM_HAMBRIENTO);
				estado = Estado.FELIZ;
			}
			case ENFERMO -> {
				System.out.println(MSG_COM_ENFERMO);
			}
		}
		System.out.println("El estado de " + getNombre() + " es: " + estado.getDescripcion());
		actualizarPeso(multiplicador*comida);
	}

	@Override
	public void comer(double comida) {
		comer(comida, getPorcentaje());
	}
}
