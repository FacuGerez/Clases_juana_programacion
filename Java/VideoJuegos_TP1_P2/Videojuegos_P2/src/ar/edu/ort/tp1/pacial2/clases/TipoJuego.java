package ar.edu.ort.tp1.pacial2.clases;

public enum TipoJuego {
    CLASICO("JuegoClasico"),
    MULTIJUGADOR("JuegoMultijugador"),
    EDICIONESPECIAL("JuegoEdicionEspecial");

    private String descripcion;

    TipoJuego(String text){
        descripcion = text;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
