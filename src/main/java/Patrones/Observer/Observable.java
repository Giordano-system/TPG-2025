package Patrones.Observer;

import java.util.ArrayList;

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
        if (observador == null) {
            assert (false) : "El observador no puede ser nulo.";
        }
        this.observadores.add(observador);
    }

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
