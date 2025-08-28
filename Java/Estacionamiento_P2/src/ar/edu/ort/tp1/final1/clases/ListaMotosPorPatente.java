package ar.edu.ort.tp1.final1.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaMotosPorPatente extends ListaOrdenadaNodos<String, Moto> {
    @Override
    public int compare(Moto dato1, Moto dato2) {
        return dato1.getPatente().compareTo(dato2.getPatente());
    }

    @Override
    public int compareByKey(String clave, Moto elemento) {
        return clave.compareTo(elemento.getPatente());
    }
}
