package ar.edu.ar.ort.parcial2.clases;

public class SemiPostal extends Sello{
    private final Float COSTOPOSTAL = Float.parseFloat("0.08");

    public SemiPostal(String pais, String pieDeimprenta, Float valorFacial, Formato formato, Impresion tipoDeImpresion) {
        super(pais, pieDeimprenta, valorFacial, formato, tipoDeImpresion);
    }

    @Override
    public Float calcularValorSello() {
        return super.getValorFacial() +  COSTOPOSTAL + super.getFormato().obtenerValor();
    }

    @Override
    public String toString() {
        return "SemiPostal";
    }
}
