package ar.edu.ort.tp1.pacial1.clases;

public class Sillon extends Mueble {

	//TODO A completar
	private int cantCuerpos;
	private TelaSillon tela;
	
	public Sillon(String modelo, float costoBase, float porcentajeGanancia, int cantCuerpos, TelaSillon tela) {
		super(modelo, costoBase, porcentajeGanancia);
		setCantCuerpos(cantCuerpos);
		setTela(tela);
	}

	public int getCantCuerpos() {
		return cantCuerpos;
	}

	public void setCantCuerpos(int cantCuerpos) {
		this.cantCuerpos = cantCuerpos;
	}

	public TelaSillon getTela() {
		return tela;
	}

	public void setTela(TelaSillon tela) {
		this.tela = tela;
	}

	@Override
	public float calcularPrecioCosto() {
		return (this.getCostoBase() * this.cantCuerpos * this.tela.getPorcentaje());
	}

}
