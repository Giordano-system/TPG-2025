package Modelo.Datos.clases;

import Modelo.Negocio.clases.*;
import Patrones.Observer.ObservadorAmbulancia;
import Patrones.Observer.ObservadorAsociados;
import Patrones.Observer.ObservadorOperario;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ModuloSimulacion {


    public ModuloSimulacion() {
    }


    public void iniciarSimulacion(ArrayList<Asociado> asociados, Operario operario, Ambulancia ambulancia, int solicitudesPorAsociado) {

        if (asociados.isEmpty() || operario == null) {
            assert (false) : "Los asociados o el operario no están correctamente inicializados.";
        }


        // Convertir cada asociado en un hilo y tambien el operario
        Thread[] hilos = new Thread[asociados.size()];
        for (int i = 0; i < asociados.size(); i++) {
            hilos[i] = new ThreadAsociado(asociados.get(i), ambulancia, solicitudesPorAsociado);
        }

        System.out.println("Iniciando Simulacion");

        // Iniciar todos los hilos
        for (Thread hilo : hilos) {
            hilo.start();
        }

    }


    /**
     * <b>Pre:</b> El operario y la ambulancia deben estar correctamente inicializados.
     * Inicia el hilo para que el operario realice el mantenimiento de la ambulancia
     * <b>Post:</b> El operario habra iniciado el mantenimiento de la ambulancia.
     */

    public void mandarAMantenimiento(Operario operario, Ambulancia ambulancia) {
        if (operario == null || ambulancia == null) {
            assert (false) : "El operario o la ambulancia no están correctamente inicializados.";
        }
        ThreadOperario threadOperario = new ThreadOperario(operario, ambulancia);
        threadOperario.start();
    }

    public void finalizarSimulacion(Ambulancia ambulancia) {
        ambulancia.finalizaSimulacion();
    }



}
