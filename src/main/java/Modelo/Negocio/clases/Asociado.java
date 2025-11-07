package Modelo.Negocio.clases;

import Modelo.Datos.clases.Persona;
import Patrones.Observer.IObservable;
import Patrones.Observer.IObservador;

import java.util.ArrayList;

/**
 * Clase que representa a un Asociado.
 * Hereda de la clase Persona.
 * @author Grupo 9 - POO
 * @version 1.0
 */
public class Asociado extends Persona implements IObservable {

    private ArrayList<IObservador> observadores ;

	/**
     * Constructor de la clase Asociado.
     * <b>PRE:</b> nombre!=null, nombre!="", apellido!=null, apellido!="", dni!=null, dni!="", calle!=null, calle!="", telefono!=null, telefono!="", ciudad!=null, ciudad!="", numero > 0.
     * @param nombre Nombre del asociado.
     * @param apellido Apellido del asociado.
     * @param dni Documento del asociado.
     * @param calle Nombre de la calle (Domicilio)
     * @param numero Numero de la calle (Domicilio)
     * @param telefono Numero de telefono del asociado.
     * @param ciudad Ciudad del asociado.
     */
	public Asociado(String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad) {
		super(nombre, apellido, dni, calle, numero, telefono, ciudad);
        this.observadores = new ArrayList<>();
	}


    public String toString() {
    	return "Asociado: " + nombre;
    }

    /**
     * <b>Pre:</b> El observador no debe estar en la lista de observadores. Ni ser nulo.
     * Agrega un observador a la lista de observadores.
     * @param observador
     * <b>Post:</b> El observador habrá sido agregado a la lista de observadores.
     */

    @Override
    public void agregarObservador(IObservador observador) {
        if (observadores.contains(observador)) {
            assert (false) : "El observador ya está en la lista de observadores.";
        }
        if (observador == null) {
            assert (false) : "El observador no puede ser nulo.";
        }
        observadores.add(observador);
    }

    /**
     * <b>Pre:</b> El observador debe estar en la lista de observadores.
     * Elimina un observador de la lista de observadores.
     * @param observador
     * <b>Post:</b> El observador habrá sido eliminado de la lista de observadores.
     */

    @Override
    public void eliminarObservador(IObservador observador) {
        if (!observadores.contains(observador)) {
            assert (false) : "El observador no está en la lista de observadores.";
        }
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
