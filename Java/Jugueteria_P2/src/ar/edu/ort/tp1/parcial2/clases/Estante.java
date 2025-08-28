package ar.edu.ort.tp1.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;

public class Estante implements ContenedorInteligente<Juguete, Integer>{
    private PilaNodos<Juguete> contenedor;
    private int capacidad;
    private int contador = 0;
    private TipoDeJuguete tipo;

    public Estante(int capacidad) {
        this.capacidad = capacidad;
        contenedor = new PilaNodos<>();
        tipo = null;
    }

    public boolean isFull(){
        return capacidad == contador;
    }

    public TipoDeJuguete getTipo(){
        if (contenedor.isEmpty()){
            tipo = null;
        }
        return tipo;
    }

    @Override
    public void guardar(Juguete elemento) {
        if (contenedor.isEmpty()) {
            tipo = elemento.getTipo();
        }
        if (capacidad == contador){
            throw new RuntimeException("Estante lleno.");
        }
        if (elemento.getTipo() != tipo) {
            throw new RuntimeException("No se puede almacenar un juguete de tipo " + elemento.getTipo() + " en un estante de tipo " + tipo);
        }
        contador++;
        contenedor.push(elemento);
    }

    @Override
    public Juguete recuperarPorId(Integer id) {
        Juguete devolver = null;
        PilaNodos<Juguete> aux = new PilaNodos<>();
        while (!contenedor.isEmpty()){
            if (contenedor.peek().getId() == id){
                devolver = contenedor.pop();
                contador--;
            }else {
                aux.push(contenedor.pop());
            }
        }
        while (!aux.isEmpty()){
            contenedor.push(aux.pop());
        }
        return devolver;
    }
}
