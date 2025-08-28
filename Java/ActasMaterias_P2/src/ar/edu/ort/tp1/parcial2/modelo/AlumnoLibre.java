package ar.edu.ort.tp1.parcial2.modelo;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;

public class AlumnoLibre extends Alumno {

	// TODO -- agregar al alumno libre las notas de sus examenes rendidos previamente.
	private PilaNodos<Integer> notasAnteriores;

	public AlumnoLibre(int dni, String nombre, int nroCurso, int notaFinalCursada) {
		super(dni, nombre, nroCurso, notaFinalCursada);
		notasAnteriores = new PilaNodos<>();
	}
	
	@Override
	public TipoExamen obtenerTipoExamen() {
		return TipoExamen.FINAL_PRACTICO;
	}

	public void agregarNota(int nota) {
		notasAnteriores.push(nota);
	}

	@Override
	public TipoAlumno getTipo() {
		return TipoAlumno.LIBRE;
	}
}
