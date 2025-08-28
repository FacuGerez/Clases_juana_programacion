package ar.edu.ort.tp1.parcial2.clases;

public class Jugueteria implements ContenedorInteligente<Juguete, Integer> {

    private static final int ALTO_ESTANTERIA = 6;
    private static final int ANCHO_ESTANTERIA = 3;
    private static final int PROFUNDIDAD_ESTANTERIA = 4;

    private int profundidad;
    private Estante[][] juguetes = new Estante[ALTO_ESTANTERIA][ANCHO_ESTANTERIA];
    private float totalVentas = 0;

    public Jugueteria() {
        profundidad = PROFUNDIDAD_ESTANTERIA;
        cargarMatriz();
    }

    public Jugueteria(int profundidad) {
        this.profundidad = profundidad;
        cargarMatriz();
    }

    private void cargarMatriz(){
        for (int i = 0; i < ALTO_ESTANTERIA; i++) {
            for (int j = 0; j < ANCHO_ESTANTERIA; j++) {
                juguetes[i][j] = new Estante(profundidad);
            }
        }
    }

    public void mostrarVentas() {
        System.out.printf("El total de ventas fue de $%.1f\n", totalVentas);
        System.out.println("--------------------------------------------");
    }

    public boolean existeJuguete(int id) {
        boolean devolver = false;
        Juguete aux = null;
        for (int i = 0; i < ALTO_ESTANTERIA; i++) {
            for (int j = 0; j < ANCHO_ESTANTERIA; j++) {
                if (!devolver) {
                    aux = juguetes[i][j].recuperarPorId(id);
                    if (aux != null) {
                        devolver = aux.getId() == id;
                        juguetes[i][j].guardar(aux);
                    }
                }

            }
        }
        return devolver;
    }

    @Override
    public void guardar(Juguete elemento) {
        boolean guardado = false;
        for (int i = 0; i < ALTO_ESTANTERIA; i++) {
            for (int j = 0; j < ANCHO_ESTANTERIA; j++) {
                if (!guardado) {
                    if (!juguetes[i][j].isFull() && (juguetes[i][j].getTipo() == null || elemento.getTipo() == juguetes[i][j].getTipo())) {
                        juguetes[i][j].guardar(elemento);
                        guardado = true;
                    }
                }
            }
        }
        if (!guardado) {
            throw new RuntimeException("No se pudo depositar el juguete.");
        }
    }

    @Override
    public Juguete recuperarPorId(Integer id) {
        Juguete devolver = null;
        for (int i = 0; i < ALTO_ESTANTERIA; i++) {
            for (int j = 0; j < ANCHO_ESTANTERIA; j++) {
                if (devolver == null){
                    devolver = juguetes[i][j].recuperarPorId(id);
                }
            }
        }
        if (devolver != null) {
            totalVentas += devolver.getPrecio();
        }
        return devolver;
    }
}
