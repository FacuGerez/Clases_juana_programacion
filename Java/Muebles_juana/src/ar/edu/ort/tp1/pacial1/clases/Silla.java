package ar.edu.ort.tp1.pacial1.clases;

public class Silla extends Mueble {

	private static final int COEFICIENTE_SILLA = 3;
	
	//TODO A completar
	private long alto;
	private MaterialSilla materialSilla;
	
	public Silla(String modelo, float costoBase, float porcentajeGanancia, long alto, MaterialSilla materialSilla) {
		super(modelo, costoBase, porcentajeGanancia);
		setAlto(alto);
		setMaterialSilla(materialSilla);
	}

	public long getAlto() {
		return alto;
	}

	public void setAlto(long alto) {
		this.alto = alto;
	}

	public MaterialSilla getMaterialSilla() {
		return materialSilla;
	}

	public void setMaterialSilla(MaterialSilla materialSilla) {
		this.materialSilla = materialSilla;
	}

	@Override
	public float calcularPrecioCosto() {
		return (this.getCostoBase() + this.materialSilla.getMultiplicadorValor() * this.alto);
	}

}
