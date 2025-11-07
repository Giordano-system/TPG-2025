package Patrones.Observer;

public interface IObservador {

    public void update(IObservable obj, String evento);

    public void agregarObservado(IObservable obj);

    public void eliminarObservado(IObservable obj);

}
