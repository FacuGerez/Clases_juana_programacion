package Cerveceria;

import java.util.ArrayList;

public class Cajon extends Contenedor {
    ArrayList<Botella> botellas = new ArrayList<>();
    public Cajon(Sabor sabor){
        super(sabor);
        for (int i= 0; i<12; i++){
            botellas.add(new Botella(sabor));
        }
    }

    @Override
    protected EnvaseCerveza extraer() {
        return botellas.removeLast();
    }

    @Override
    public boolean estaVacio() {
        return botellas.isEmpty();
    }
}
