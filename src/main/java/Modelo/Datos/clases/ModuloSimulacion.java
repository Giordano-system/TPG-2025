package Modelo.Datos.clases;

import Controlador.Controlador;
import Modelo.Negocio.clases.*;
import Patrones.Observer.ObservadorAmbulancia;
import Patrones.Observer.ObservadorAsociados;
import Vista.IVista;
import Vista.VistaConfig;
import Vista.VistaSimulacion;

import java.util.ArrayList;

public class ModuloSimulacion {

    Ambulancia ambulancia;
    ArrayList<Asociado> asociados;
    Operario operario;

    public ModuloSimulacion() {
        this.ambulancia = new Ambulancia();
        this.operario = new Operario("Valentino", "Giordano", "46632600", "España", 1459, "5964847", "Tokio");
        this.asociados = new ArrayList<>();
        cargaInformal();
    }

    /**
     * <b>Pre:</b> Los observadores deben estar correctamente inicializados.
     * Agrega los observadores a la ambulancia y a los asociados.
     * @param observadorAsociados
     * @param observadorAmbulancia
     * <b>Post:</b> Los observadores habrán sido agregados correctamente. Por su mismo lado, los observados habrán incorporado a sus listas de observadores a los observadores correspondientes.
     */

    public void agregarObservadores(ObservadorAsociados observadorAsociados, ObservadorAmbulancia observadorAmbulancia) {
        if (observadorAsociados == null || observadorAmbulancia == null) {
            assert (false) : "Los observadores no pueden ser nulos.";
        }
        ambulancia.agregarObservador(observadorAmbulancia);
        for (Asociado asociado : asociados) {
            observadorAsociados.agregarAsociado(asociado);
        }
    }

    public void cargaInformal() {
        Asociado a1 = new Asociado("Agustin", "Proia", "46112190", "Mendoza", 912, "1234567", "Tokio", 3);
        Asociado a2 = new Asociado("Pedro", "Gutierrez", "46112190", "Mendoza", 912, "1234567", "Tokio", 3);
        Asociado a3 = new Asociado("Lionel", "Messi", "46112190", "Mendoza", 912, "1234567", "Tokio", 3);

        asociados.add(a1);
        asociados.add(a2);
        asociados.add(a3);
    }

    /**
     * Devuelve la lista de asociados.
     * @return ArrayList<Asociado> Lista de asociados.
     */

    public ArrayList<Asociado> getAsociados(){
        return asociados;
    }

    /**
     * <b>Pre:</b> Los asociados y el operario deben estar correctamente inicializados.
     * Inicia la simulación creando y arrancando los hilos para cada asociado y el operario.
     * Cada asociado y el operario interactúan con la ambulancia en sus respectivos hilos
     * <b>Post: La simulacion deberia realizarse sin problema alguno.</b>
     */

    public void iniciarSimulacion() {

        if (asociados.isEmpty() || operario == null) {
            assert (false) : "Los asociados o el operario no están correctamente inicializados.";
        }

        // Convertir cada asociado en un hilo y tambien el operario
        Thread[] hilos = new Thread[asociados.size() + 1];
        for (int i = 0; i < asociados.size(); i++) {
            hilos[i] = new ThreadAsociado(asociados.get(i), ambulancia);
        }
        hilos[asociados.size()] = new ThreadOperario(operario, ambulancia);

        System.out.println("Iniciando Simulacion");

        // Iniciar todos los hilos
        for (Thread hilo : hilos) {
            hilo.start();
        }


        System.out.println("Simulacion Finalizada");
        // Actualizar la vista para indicar que la simulación ha finalizado

    }

}
