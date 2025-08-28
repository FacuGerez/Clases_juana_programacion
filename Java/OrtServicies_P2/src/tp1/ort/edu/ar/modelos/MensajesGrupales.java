package tp1.ort.edu.ar.modelos;

public class MensajesGrupales extends Mensaje{
    public MensajesGrupales(Prioridad prioridad) {
        super(prioridad);
    }
    @Override
    public Respuesta ejecutar(Servicio srv) {
        if (srv.puedeServicio(getPrioridad())) {
            return Respuesta.OK;
        }
        return Respuesta.ERROR;
    }
}
