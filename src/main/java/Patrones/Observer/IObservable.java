package Patrones.Observer;

public interface IObservable {

    public void agregarObservador(IObservador observador);

    public void eliminarObservador(IObservador observador);

    public int cantObservadores();

    public void deleteObservadores();

    public void notificarObservadores(String evento);

}
