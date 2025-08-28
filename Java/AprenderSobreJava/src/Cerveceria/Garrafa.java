package Cerveceria;
public class Garrafa extends EnvaseCerveza {
    private Medida medida;
    private String tipo;
    public Garrafa(Sabor sabor, Medida m){
        super(sabor);
        medida = m;
        int precio = 160;
        setPrecioVenta(precio);
        tipo = "GARRAFA ";
        switch (medida){
            case GRANDE :
                tipo += "GRANDE";
                break;
            case MEDIANA:
                tipo += "MEDIANA";
                break;
            case CHICA:
                tipo += "CHICA";
                break;
        }
    }
    @Override
    protected void setPrecioVenta(double precio) {
        switch (medida){
            case GRANDE :
                super.precioVenta = precio * 3;
                break;
            case MEDIANA:
                super.precioVenta = precio * 1.5 * 1.1;
                break;
            case CHICA:
                super.precioVenta = precio * 0.75 * 1.2;
                break;
        }
        return;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
