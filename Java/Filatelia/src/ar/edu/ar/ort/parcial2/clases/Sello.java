package ar.edu.ar.ort.parcial2.clases;

public abstract class Sello {

	private final String pais;
	private final String pieDeimprenta;
	private final Float valorFacial;
	private final Formato formato;
	private final Impresion tipoDeImpresion;
	/*TODO
	Desarrollar constructores, estructuras, métodos
	y excepciones pedidos
	en el enunciado*/

	public Sello(String pais, String pieDeimprenta, Float valorFacial, Formato formato, Impresion tipoDeImpresion) {
		RangoNumeros comprobacion = new RangoNumeros((float) 0.50,(float)0.90);
		if (pieDeimprenta == null || pieDeimprenta.isEmpty()) throw new IllegalArgumentException(Visualizable.ERROR_PIE_NULO);
		if (!comprobacion.incluye(valorFacial)) throw new IllegalArgumentException("Valor facial fuera del rango aceptable");
		this.pais = pais;
		this.pieDeimprenta = pieDeimprenta;
		this.valorFacial = valorFacial;
		this.formato = formato;
		this.tipoDeImpresion = tipoDeImpresion;
	}

	public String getPieDeimprenta() {
		return pieDeimprenta;
	}

	public Float getValorFacial() {
		return valorFacial;
	}

	public Impresion getTipoDeImpresion() {
		return tipoDeImpresion;
	}

	public Formato getFormato() {
		return formato;
	}

	public String verDatos(){
		return String.format("--%s(%s)Facial=%.1f--%s--%s",pais,pieDeimprenta,valorFacial,formato,tipoDeImpresion);
	}

	public abstract Float calcularValorSello();

	@Override
	public abstract String toString();
}
