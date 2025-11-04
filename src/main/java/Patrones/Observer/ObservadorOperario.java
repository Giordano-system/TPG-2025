package Patrones.Observer;

import Controlador.Controlador;

import Modelo.Negocio.clases.Operario;

import java.util.ArrayList;

public class ObservadorOperario implements IObservador {

    private Controlador controlador;
    private ArrayList<Operario> operarios;

    /**
     * <b>Pre: Controlador !=null</b>
     * Constructor de la clase ObservadorOperario.
     * <b>Post: Se crea la instancia de Observador Operario</b>
     */

    public ObservadorOperario(Controlador controlador) {
        if (controlador == null) {
            assert (false) : "El controlador no puede ser nulo.";
        }
        this.controlador = controlador;
        this.operarios = new ArrayList<>();
    }

    /**
     * <b>Pre:</b> El operario debe ser una instancia de Operario y tambien no debe estar en la lista de operarios observados.
     * Agrega un operario a la lista de operarios observados.
     * @param operario
     * <b>Post:</b> El operario habrá sido agregado a la lista de operarios observados.
     */

    public void agregarOperario(Operario operario) {
        if (operarios.contains(operario)) {
            assert (false) : "El operario ya está en la lista de operarios observados.";
        }
        if (operario == null)
            assert (false) : "El operario no puede ser nulo.";
        this.operarios.add(operario);
        operario.agregarObservador(this);
    }

    /**
     * <b>Pre:</b> El operario debe estar en la lista de operarios observados. Ademas de ser una instancia de Operario.
     * @param operario
     * <b>Post:</b> El operario habrá sido eliminado de la lista de operarios observados.
     */

    public void eliminarOperario(Operario operario) {
        if (!operarios.contains(operario)) {
            assert (false) : "El operario no está en la lista de operarios observados.";
        }
        this.operarios.remove(operario);
    }

    /**
     * <b>Pre: El objeto debe ser una instancia de Operario y ser un operario observado.</b>
     * Actualiza la vista cuando un operario cambia.
     * @param obj
     * @param evento
     * <b>Post:</b> La vista del operario habrá sido actualizada en el controlador.
     */

    public void update(IObservable obj, String evento) {
        if (obj == null){
            assert (false) : "El objeto observado no puede ser nulo.";
        }
        Operario operarioActualizado = (Operario) obj;
        if (operarios.contains(operarioActualizado)) {
            controlador.actualizarAreaOperario(evento);
        } else {
            assert (false) : "El operario observado no está en la lista de operarios observados.";
        }
    }




}
