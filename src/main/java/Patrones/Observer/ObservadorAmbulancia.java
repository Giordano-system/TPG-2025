package Patrones.Observer;

import Controlador.Controlador;
import Modelo.Negocio.clases.Ambulancia;

public class ObservadorAmbulancia implements IObservador {

    private String estadoAmbulancia;
    private Controlador controladorVista;

    /**
     * Constructor de la clase ObservadorAmbulancia.
     * @param controladorVista Controlador de la vista para actualizar el estado de la ambulancia.
     */

    public ObservadorAmbulancia(Controlador controladorVista) {
        this.estadoAmbulancia = "Disponible";
        controladorVista = controladorVista;
    }


    /**
     * Actualiza el estado de la ambulancia y notifica al controlador de la vista.
     * El controlador de la vista se encarga de avisarle a la vista que hay que actualizar la interfaz de usuario con el nuevo estado de la ambulancia.
     * @param obj Objeto observado (Ambulancia).
     * @param evento Evento que desencadena la actualización.
     */

    @Override
    public void update(Object obj, String evento) {
        Ambulancia ambulancia = (Ambulancia) obj;
        this.estadoAmbulancia = ambulancia.getEstado().getNombre();
        if (controladorVista != null) {
            controladorVista.actualizarEstadoAmbulancia(estadoAmbulancia);
        }
    }
}
