package Patrones.Observer;

import Controlador.Controlador;
import Modelo.Negocio.clases.Asociado;

import java.util.ArrayList;

/**
 * Clase que representa un observador de asociados.
 * Implementa la interfaz IObservador.
 * @author Grupo 9 - POO
 * @version 2.0
 */

public class ObservadorAsociados implements IObservador{

    private Controlador controlador;
    private ArrayList<IObservable> asociados;

    public ObservadorAsociados(Controlador controlador) {
        this.controlador = controlador;
        this.asociados = new ArrayList<>();
    }

    /**
     * <b>Pre:</b> El asociado debe ser una instancia de Asociado y tambien no debe estar en la lista de asociados observados.
     * Agrega un asociado a la lista de asociados observados.
     * @param asociado
     * <b>Post:</b> El asociado habrá sido agregado a la lista de asociados observados.
     */

    public void agregarObservado(IObservable asociado) {
       
        
        assert asociados.contains(asociado)==false : "El asociado ya está en la lista de asociados observados.";
        
        assert asociado!=null : "El asociado no puede ser nulo.";
        
        this.asociados.add(asociado);
        asociado.agregarObservador(this);
    }

    /**
     * <b>Pre:</b> El asociado debe estar en la lista de asociados observados. Ademas de ser una instancia de Asociado.
     * Elimina un asociado de la lista de asociados observados.
     * @param asociado
     * <b>Post:</b> El asociado habrá sido eliminado de la lista de asociados observados.
     */

    public void eliminarObservado(IObservable asociado) {
        
        assert asociados.contains(asociado)==true : "El asociado no está en la lista de asociados observados.";
        
        this.asociados.remove(asociado);
        asociado.eliminarObservador(this);
    }

    /**
     * Elimina todos los asociados de la lista de asociados observados.
     * <b>Post:</b> La lista de asociados observados estará vacia.
     */

    public void eliminarTodosAsociados() {
        for (IObservable asociado : asociados) {
            asociado.eliminarObservador(this);
        }
        asociados.clear();
    }


    /**
     * <b>Pre: El objeto debe ser una instancia de Asociado y ser un asociado observado.</b>
     * Actualiza la vista cuando un asociado cambia.
     * @param obj Objeto observado, en este caso un Asociado.
     * @param evento Evento que desencadena la actualización.
     * <b>Post:</b> La vista del asociado habrá sido actualizada en el controlador.
     */

    @Override
    public void update(IObservable obj, String evento) {
    	
    	assert asociados.contains(obj) == true : "El observado no esta en la lista de observados en el ojo ";
        
        if (asociados.contains(obj)) {
            controlador.actualizarVistaAsociado(evento);
        }
    }


}
