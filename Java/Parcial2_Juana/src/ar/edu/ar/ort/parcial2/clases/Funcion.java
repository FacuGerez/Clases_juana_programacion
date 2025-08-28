package ar.edu.ar.ort.parcial2.clases;
// TODO: CORREGIDO FACU


public class Funcion {
    private TiposDeFuncion tipo;
    private String pelicula;
    private AcreditacionesPorDNI acreditados;

    public Funcion(TiposDeFuncion tipo, String pelicula, AcreditacionesPorDNI acreditados) {
        this.tipo = tipo;
        this.pelicula = pelicula;
        this.acreditados = acreditados;
    }
    @Override
    public String toString() {
        return "Funcion [titulo=" + pelicula + ", tipoDeFuncion=" + tipo + ", acreditados=" + acreditados.size() + "]";
    }
}