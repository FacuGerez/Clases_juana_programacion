package ar.edu.ar.ort.parcial2.clases;

public class SelloConmemorativo extends Sello{
    private final Tematica tematica;

    public SelloConmemorativo(String pais, String pieDeimprenta, Float valorFacial, Formato formato, Impresion tipoDeImpresion, Tematica tematica) {
        super(pais, pieDeimprenta, valorFacial, formato, tipoDeImpresion);
        this.tematica = tematica;
    }

    @Override
    public Float calcularValorSello() {
        if (super.getFormato() == Formato.REDONDO && tematica == Tematica.CEREMONIAL){
            return super.getValorFacial() + super.getFormato().obtenerValor();
        }else{
            return super.getValorFacial();
        }
    }

    @Override
    public String toString() {
        return "SelloConmemorativo";
    }
}
