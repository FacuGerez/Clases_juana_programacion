package ar.edu.ort.tp1.parcial2.modelo;

import java.util.ArrayList;
import java.util.Random;

public class Instituto {

	private String nombre;
	private ArrayList<Materia> materias;

	public Instituto(String nombre) {
		this.nombre = nombre;
		this.materias = new ArrayList<Materia>();
		precargarAlumnos();
		prepararActas();
	}

	private boolean booleanAleatorio() {
		return Math.random() < 0.5;
	}

	private void cargarAlumnosAMateria(String nombre, int cantAlumnosReg, int cantAlumnosLibres) {
		Materia m = new Materia(nombre);
		for (int i = 0; i < cantAlumnosReg; i++) {
			m.inscribir(new AlumnoRegular(10000000 + i, "Nombre " + i, enteroAleatorio(1, 10), enteroAleatorio(1, 10),
					booleanAleatorio()));
		}
		for (int i = 0; i < cantAlumnosLibres; i++) {
			AlumnoLibre a = new AlumnoLibre(20000000 + i, "Nombre " + i, enteroAleatorio(1, 10),
					enteroAleatorio(4, 10));
			int cantVueltas = enteroAleatorio(1, 2);
			 for (int j = 0; j < cantVueltas; j++) {
				 a.agregarNota(enteroAleatorio(1, 3));
			 }

			m.inscribir(a);
		}
		materias.add(m);
	}

	public void cambiarNota(String nombreMateria, int dniAlumno, int nota) {
		try {
			System.out.println("-- Actualizando con " + Integer.toString(nota)  + " la nota del alumno con el dni " + Integer.toString(dniAlumno) + " en la materia "+ nombreMateria);
			Materia materiaBuscada = null;
			for (Materia materia : materias) {
				if (materiaBuscada == null && materia.getNombre().equals(nombreMateria)) {
					materiaBuscada = materia;
					materia.actualizarNotaAlumno(dniAlumno, nota);
					System.out.println("   Se actualizo con "+ Integer.toString(nota) +" la nota del alumno con el dni "+ Integer.toString(dniAlumno) +" en la materia "+ nombreMateria);
				}
			}
			if (materiaBuscada == null) {
				throw new RuntimeException("Esta materia no se encontro");
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}

	private int enteroAleatorio(int min, int max) {
		return new Random().nextInt(max - min + 1) + min;
	}

	private void precargarAlumnos() {
		int i = 1;
		cargarAlumnosAMateria("Mat" + i++, 30, 20);
		cargarAlumnosAMateria("Mat" + i++, 40, 10);
		cargarAlumnosAMateria("Mat" + i++, 45, 5);
		cargarAlumnosAMateria("Mat" + i++, 10, 40);
	}

	private void prepararActas() {
		for (Materia materia : materias) {
			materia.asignarActas();
		}
	}

	public void informarActasPorMateriaYCurso() {
		System.out.println("Actas de las materias del instituto " + nombre);
		for (Materia materia : materias) {
			materia.informarActasXCurso();
		}
	}
}
