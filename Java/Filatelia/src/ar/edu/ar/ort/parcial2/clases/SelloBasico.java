package ar.edu.ar.ort.parcial2.clases;

public class SelloBasico extends Sello{
    private final Disenio disenio;

    public SelloBasico(String pais, String pieDeimprenta, Float valorFacial, Formato formato, Impresion tipoDeImpresion, Disenio disenio) {
        super(pais, pieDeimprenta, valorFacial, formato, tipoDeImpresion);
        this.disenio = disenio;
    }

    @Override
    public Float calcularValorSello() {
        if(disenio == Disenio.MONARCA){
            return super.getValorFacial() + disenio.getValorDisenio();
        }else{
            return super.getValorFacial() + super.getFormato().obtenerValor();
        }
    }

    @Override
    public String toString() {
        return "SelloBasico";
    }
}
