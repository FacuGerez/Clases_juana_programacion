package ar.edu.ort.tp1.parcial2.modelo;

public class Acta {

	private TipoExamen categoria;
	// TODO -- cambiar a ordenamiento por DNI
	private AlumnosPorDni alumnos;

	public Acta(TipoExamen categoria) {
		this.categoria = categoria;
		this.alumnos = new AlumnosPorDni();
	}

	public void agregarAlumno(Alumno al) {
		this.alumnos.add(al);
	}
	
	public void removerAlumno(Alumno al) {
		this.alumnos.remove(al);
	}

	public void alumnosPorCurso(int[] cantidadAlumnosPorCurso) {
		for (Alumno alumno : alumnos) {
			cantidadAlumnosPorCurso[alumno.getCurso() - 1]++;
		}
	}
	
	public TipoExamen getCategoria() {
		return categoria;
	}

}
