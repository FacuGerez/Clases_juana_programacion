package Cerveceria;

public class Barril extends Contenedor {
    int capacidad;
    public Barril(Sabor sabor) {
        super(sabor);
        capacidad = 30;
    }

    @Override
    protected EnvaseCerveza extraer() {
        return extraerMediana();
    }
    protected EnvaseCerveza extraer(Medida medida) {
        EnvaseCerveza devolver;
        switch (medida){
            case GRANDE -> {
                devolver = extraerGrande();
            }
            case CHICA ->  {
                devolver = extraerChica();
            }
            default -> {
                devolver = extraerMediana();
            }
        }
        return devolver;
    }

    private EnvaseCerveza extraerGrande(){
        if (capacidad >= 3) {
            capacidad -= 3;
            return new Garrafa(getSabor(), Medida.GRANDE);
        }
        return extraerMediana();
    }
    private EnvaseCerveza extraerMediana(){
        if (capacidad >= 3/2) {
            capacidad -= 3/2;
            return new Garrafa(getSabor(), Medida.MEDIANA);
        }
        return extraerChica();
    }
    private EnvaseCerveza extraerChica(){
        if (capacidad >= 3/4) {
            capacidad -= 3/4;
            return new Garrafa(getSabor(), Medida.CHICA);
        }
        return null;
    }

    @Override
    public boolean estaVacio() {
        return capacidad == 0;
    }
}
