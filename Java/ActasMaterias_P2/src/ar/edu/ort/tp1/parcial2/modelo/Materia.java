package ar.edu.ort.tp1.parcial2.modelo;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;

public class Materia {

	private static final int CANTIDAD_CURSOS = 10;
	private String nombre;
	private Acta[] actas;
	private AlumnosPorDni inscriptos;

	public Materia(String nombre) {
		this.nombre = nombre;
		inscriptos = new AlumnosPorDni();
	}

	public void inscribir(Alumno a) throws RuntimeException {
		if (!inscriptos.exists(a.getDni())) {
			inscriptos.add(a);
		}
	}

	public void asignarActas() {
		inicializarActas();

		for (Alumno a : inscriptos) {
			TipoExamen tipoExamen = a.obtenerTipoExamen();
			if (tipoExamen != null) {
				actas[tipoExamen.ordinal()].agregarAlumno(a);
			}
		}
	}

	private void inicializarActas() {
		actas = new Acta[TipoExamen.values().length];
		for (int i = 0; i < actas.length; i++) {
			actas[i] = new Acta(TipoExamen.values()[i]);
		}
	}

	public void informarActasXCurso() {
		if (actas[0] != null) {
			System.out.println("Alumnos por acta de la materia: " + nombre);
			int[][] cantidades = obtenerMatriz();
			mostrarMatriz(cantidades);
		}
	}

	private int[][] obtenerMatriz() {
		int[][] cantidades = new int[TipoExamen.values().length + 1][CANTIDAD_CURSOS];
		for (int iFila = 0; iFila < actas.length; iFila++) {
			Acta acta = actas[iFila];
			acta.alumnosPorCurso(cantidades[iFila]);
		}
		for (int fila=0; fila < cantidades.length - 1 ; fila++) {
			for (int columna=0; columna < cantidades[fila].length; columna++) {
				cantidades[TipoExamen.values().length][columna] += cantidades[fila][columna];
			}
		}

		return cantidades;
	}

	private void mostrarMatriz(int[][] cantidades) {
		System.out.printf("%15s", "Curso");
		for (int i = 0; i < CANTIDAD_CURSOS; i++) {
			System.out.printf("%5d", 1+i);
		}
		System.out.println();
		for (int iFila = 0; iFila < TipoExamen.values().length; iFila++) {
			TipoExamen te = TipoExamen.values()[iFila];
			System.out.printf("%15s", te);
			for (int iColumna = 0; iColumna < cantidades[iFila].length; iColumna++) {
				System.out.printf("%5d", cantidades[iFila][iColumna]);
			}
			System.out.println();
		}
		System.out.printf("%15s", "TOTAL");
		for (int iColumna = 0; iColumna < CANTIDAD_CURSOS; iColumna++) {
			System.out.printf("%5d", cantidades[TipoExamen.values().length][iColumna]);
		}
		System.out.println();

	}

	public String getNombre() {
		return nombre;
	}

	public void actualizarNotaAlumno(Integer dni, int nota) {
		for (Alumno alumno : inscriptos) {
			if (alumno.getDni() == dni) {
				if (alumno.getTipo() == TipoAlumno.REGULAR) {
					alumno.setNotaFinalCursada(nota);
					return;
				}else{
					throw new RuntimeException("No se puede actualizar nota de un alumno libre");
				}
			}
		}
		throw new RuntimeException("Alumno no encontrado");
	}

}