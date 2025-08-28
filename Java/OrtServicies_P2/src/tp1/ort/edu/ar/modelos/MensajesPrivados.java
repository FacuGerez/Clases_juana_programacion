package tp1.ort.edu.ar.modelos;

public class MensajesPrivados extends Mensaje{
    private int idServicioDeDestino;

    public MensajesPrivados(Prioridad prioridad, int idServicioDeDestino) {
        super(prioridad);
        this.idServicioDeDestino = idServicioDeDestino;
    }

    @Override
    public Respuesta ejecutar(Servicio srv) {
        if (srv.getId() == idServicioDeDestino) {
            return Respuesta.OK;
        }
        return Respuesta.ERROR;
    }
}
