package Patrones.Observer;

import Controlador.Controlador;

import Modelo.Negocio.clases.Operario;

import java.util.ArrayList;

/**
 * Clase que representa un observador de operarios.
 * Implementa la interfaz IObservador.
 * @author Grupo 9 - POO
 * @version 2.0
 */

public class ObservadorOperario implements IObservador {

    private Controlador controlador;
    private ArrayList<IObservable> operarios;

    /**
     * <b>Pre: Controlador !=null</b>
     * Constructor de la clase ObservadorOperario.
     * <b>Post: Se crea la instancia de Observador Operario</b>
     */

    public ObservadorOperario(Controlador controlador) {
    	
    	assert controlador!=null : "El controlador no puede ser nulo.";
    	
        this.controlador = controlador;
        this.operarios = new ArrayList<>();
    }

    /**
     * <b>Pre:</b> El operario debe ser una instancia de Operario y tambien no debe estar en la lista de operarios observados.
     * Agrega un operario a la lista de operarios observados.
     * @param operario
     * <b>Post:</b> El operario habrá sido agregado a la lista de operarios observados.
     */

    public void agregarObservado(IObservable operario)
    {
        
        assert operarios.contains(operario)==false: "El operario ya está en la lista de operarios observados.";
        
        assert operario != null : "El operario no puede ser nulo.";
        
        this.operarios.add(operario);
        operario.agregarObservador(this);
    }

    /**
     * <b>Pre:</b> El operario debe estar en la lista de operarios observados. Ademas de ser una instancia de Operario.
     * @param operario
     * <b>Post:</b> El operario habrá sido eliminado de la lista de operarios observados.
     */

    public void eliminarObservado(IObservable operario) {
        
    	assert operarios.contains(operario)==true : "El operario no está en la lista de operarios observados.";
    	
        operario.eliminarObservador(this);;
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
    	
    	assert obj != null : "El objeto observado no puede ser nulo.";
    	
    	assert operarios.contains(obj)==true :  "El operario observado no está en la lista de operarios observados.";
    	
        if (operarios.contains(obj)) {
            controlador.actualizarAreaOperario(evento);
        }
    }
}
