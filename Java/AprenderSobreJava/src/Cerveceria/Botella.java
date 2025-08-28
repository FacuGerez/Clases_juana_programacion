package Cerveceria;

public class Botella extends EnvaseCerveza{
    public Botella(Sabor sabor){
        super(sabor);
        super.precioVenta = 80;
    }
    @Override
    protected void setPrecioVenta(double precio) {
        super.precioVenta = precio;
    }

    @Override
    public String getTipo() {
        return "BOTELLA";
    }
}
