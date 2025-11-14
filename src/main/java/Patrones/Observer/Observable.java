package Patrones.Observer;

import java.util.ArrayList;

/**
 * Clase abstracta que representa un objeto observable en el patrón Observer.
 * Mantiene una lista de observadores y proporciona métodos para agregar,
 * eliminar y notificar a los observadores.
 * @author Grupo 9 - POO
 * @version 2.0
 */
public abstract class Observable {

    protected ArrayList<IObservador> observadores;

    public Observable() {
        this.observadores = new ArrayList<>();
    }

    /**
     * <b>Pre: El observador no debe ser nulo</b>
     * Agrega un observador a la lista de observadores.
     * @param observador
     * <b>Post:</b> El observador habrá sido agregado a la lista de observadores.
     */

    public void agregarObservador(IObservador observador) {
    	
    	assert observador!=null : "El observador no puede ser nulo.";
    	
        this.observadores.add(observador);
    }

    /**
     * Elimina un observador de la lista de observadores.
     * @param observador
     * <b>Post:</b> El observador habrá sido eliminado de la lista de observadores.
     */

    public void eliminarObservador(IObservador observador) {
        this.observadores.remove(observador);
    }



    public int cantObservadores() {
        return this.observadores.size();
    }

    public void deleteObservadores() {
        this.observadores.clear();
    }

    public abstract void notificarObservadores(String evento) ;

}
