package Patrones.Observer;

import java.util.ArrayList;

public abstract class Observable {

    protected ArrayList<IObservador> observadores;

    public Observable() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(IObservador observador) {
        this.observadores.add(observador);
    }

    public void eliminarObservador(IObservador observador) {
        this.observadores.remove(observador);
    }

    public int cantObservadores() {
        return this.observadores.size();
    }

    public void deleterObservadores() {
        this.observadores.clear();
    }


    public abstract void notificarObservadores() ;

}
