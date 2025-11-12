package Patrones.Observer;

import Controlador.Controlador;
import Modelo.Negocio.clases.Ambulancia;

import javax.swing.text.html.ObjectView;
import java.util.ArrayList;

/**
 * Clase ObservadorAmbulancia que implementa la interfaz IObservador.
 * Esta clase observa los cambios en el estado de una ambulancia y notifica al controlador de
 * la vista para actualizar la interfaz de usuario en consecuencia.
 * @author Grupo 9 - POO
 * @version 2.0
 */

public class ObservadorAmbulancia implements IObservador {

    private ArrayList<Ambulancia> ambulancias;
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
        ambulancias = new ArrayList<>();
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
        if (!ambulancias.contains(obj)) {
            assert (false) : "El objeto observado no es la ambulancia asociada a este observador.";
        }
        Ambulancia ambulancia = (Ambulancia) obj;
        if (controladorVista != null) {
            if (evento.equals("Termino la simulacion"))
                controladorVista.finalizarSim("Simulacion Finalizada", ambulancia.isSimulacion());
            else
                controladorVista.actualizarEstadoAmbulancia(ambulancia.getEstado().getNombre(), ambulancia.isSimulacion());
        }
    }

    /**
     * <b>Pre: El objeto observado debe ser una instancia de Ambulancia y no debe estar ya en la lista de ambulancias observadas.</b>
     * Agrega una ambulancia a la lista de ambulancias observadas.
     * @param obj
     * <b>Post:</b> La ambulancia habrá sido agregada a la lista de ambulancias observadas.
     */

    @Override
    public void agregarObservado(IObservable obj) {
        if (obj == null) {
            assert (false) : "El objeto observado no puede ser nulo.";
        }
        if (ambulancias.contains(obj)) {
            assert (false) : "La ambulancia ya está en la lista de ambulancias observadas.";
        }
        Ambulancia ambulancia = (Ambulancia) obj;
        ambulancias.add(ambulancia);
        obj.agregarObservador(this);
    }

    /**
     * <b>Pre: El objeto observado debe estar en la lista de ambulancias observadas</b>
     * Elimina una ambulancia de la lista de ambulancias observadas.
     * @param obj
     * <b>Post:</b> La ambulancia habrá sido eliminada de la lista de ambulancias observadas.
     */

    @Override
    public void eliminarObservado(IObservable obj) {
        if (!ambulancias.contains(obj)) {
            assert (false) : "La ambulancia no está en la lista de ambulancias observadas.";
        }
        obj.eliminarObservador(this);
        ambulancias.remove(obj);
    }
}
