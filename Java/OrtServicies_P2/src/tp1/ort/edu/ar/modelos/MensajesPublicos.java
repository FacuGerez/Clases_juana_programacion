package tp1.ort.edu.ar.modelos;

public class MensajesPublicos extends Mensaje{
    public MensajesPublicos() {
        super(Prioridad.NO_CRITICOS);
    }

    @Override
    public Respuesta ejecutar(Servicio srv) {
        return Respuesta.OK;
    }
}
