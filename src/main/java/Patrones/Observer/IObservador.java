package Patrones.Observer;

/**
 * Interfaz que define el comportamiento de un observador en el patrón Observer.
 * Permite actualizarse cuando un objeto observable notifica un cambio en su estado,
 * así como agregar y eliminar objetos observados.
 * @author Grupo 9 - POO
 * @version 2.0
 */
public interface IObservador {

    public void update(IObservable obj, String evento);

    public void agregarObservado(IObservable obj);

    public void eliminarObservado(IObservable obj);

}
