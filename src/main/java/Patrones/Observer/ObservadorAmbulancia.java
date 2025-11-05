package Patrones.Observer;

import Controlador.Controlador;
import Modelo.Negocio.clases.Ambulancia;

import javax.swing.text.html.ObjectView;

public class ObservadorAmbulancia implements IObservador {

    private Ambulancia ambulancia;
    private Controlador controladorVista;

    /**
     * <b>Pre: Ambulancia es una instancia de ambulancia y el Controlador tambien.</b>
     * Constructor de la clase ObservadorAmbulancia.
     * @param controlador Controlador de la vista para actualizar el estado de la ambulancia.
     * <b>Post: Se crea la instancia del ObservadorAmbulancia que va a observar a la ambulancia pasada como parametro</b>
     */

    public ObservadorAmbulancia(Controlador controlador) {
        if (controladorVista == null) {
            assert (false) : "El controlador no pueden ser nulos.";
        }
        controladorVista = controlador;
    }

    public void setAmbulancia(Ambulancia ambulancia) {
        if (ambulancia == null) {
            assert (false) : "La ambulancia no puede ser nula.";
        }
        this.ambulancia = ambulancia;
        ambulancia.agregarObservador(this);
    }

    /**
     * <b>Pre: El objeto observado debe ser la ambulancia asociada a este observador.</b>
     * Actualiza el estado de la ambulancia y notifica al controlador de la vista.
     * El controlador de la vista se encarga de avisarle a la vista que hay que actualizar la interfaz de usuario con el nuevo estado de la ambulancia.
     * @param obj Objeto observado por el Observador, en este caso la Ambulancia.
     * @param evento Evento que desencadena la actualización.
     * <b>Post:</b> El estado de la ambulancia habrá sido actualizado en la vista.
     */

    @Override
    public void update(IObservable obj, String evento) {
        if (obj != this.ambulancia) {
            assert (false) : "El objeto observado no es la ambulancia asociada a este observador.";
        }
        if (controladorVista != null) {
            controladorVista.actualizarEstadoAmbulancia(ambulancia.getEstado().getNombre(), ambulancia.isSimulacion());
        }
    }
}
