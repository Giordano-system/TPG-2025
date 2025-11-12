package Patrones.Observer;

/**
 * Interfaz que define el comportamiento de un objeto observable en el patrón Observer.
 * Permite agregar, eliminar y notificar observadores sobre cambios en el estado del objeto observable
 * @author Grupo 9 - POO
 * @version 2.0
 */
public interface IObservable {

    public void agregarObservador(IObservador observador);

    public void eliminarObservador(IObservador observador);

    public int cantObservadores();

    public void deleteObservadores();

    public void notificarObservadores(String evento);

}
