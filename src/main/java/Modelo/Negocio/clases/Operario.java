package Modelo.Negocio.clases;

import Modelo.Datos.clases.Persona;
import Patrones.Observer.IObservable;
import Patrones.Observer.IObservador;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que representa a un Operario.
 * Hereda de la clase Persona.
 * @author Grupo 9 - POO
 * @version 2.0
 */

public class Operario extends Persona implements IObservable {

    private ArrayList<IObservador> observadores ;

    /**
     * Constructor de la clase Operario.
     * <b>Pre:</b> nombre!=null, nombre!="", apellido!=null, apellido!="", dni!=null, dni!="", calle!=null, calle!="", telefono!=null, telefono!="", ciudad!=null, ciudad!="", numero > 0.
     * @param nombre
     * @param apellido
     * @param dni
     * @param calle
     * @param numero
     * @param telefono
     * @param ciudad
     * <b>Post:</b> Se crea la instancia del Operario con los datos pasados como parametro.
     */

    public Operario(String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad) {
        super(nombre, apellido, dni, calle, numero, telefono, ciudad);
        this.observadores = new ArrayList<>();
    }

    /**
     * <b>Pre:</b> El observador no debe ser nulo.
     * Agrega un observador a la lista de observadores.
     * @param observador
     * <b>Post:</b> El observador habrá sido agregado a la lista de observadores.
     */

    @Override
    public void agregarObservador(IObservador observador) {
        if (observador == null) {
            assert (false) : "El observador no puede ser nulo.";
        }
        this.observadores.add(observador);
    }

    /**
     * Elimina un observador de la lista de observadores.
     * @param observador
     * <b>Post:</b> El observador habrá sido eliminado de la lista de observadores.
     */

    @Override
    public void eliminarObservador(IObservador observador) {
        observadores.remove(observador);
    }

    @Override
    public int cantObservadores() {
        return observadores.size();
    }

    @Override
    public void deleteObservadores() {
        observadores.clear();
    }

    @Override
    public void notificarObservadores(String evento) {
        for (IObservador observador : observadores) {
            observador.update(this, evento);
        }
    }


}
