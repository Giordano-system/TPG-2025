package Modelo.Negocio.clases;

import java.util.Random;

/**
 * Hilo que representa la tarea de un operario realizando mantenimiento en una ambulancia.
 * @author Grupo 9 - POO
 * @version 2.0
 */

public class ThreadOperario extends Thread {

    private Operario operario;
    private Ambulancia ambulancia;

    /**
     * <b>Pre: operario una instancia de Operario !=null, y ambulancia una instancia de Ambulancia !=null</b>
     * @param operario
     * @param ambulancia
     * <b>Post: Se crea el hilo para que el operario realice su tarea en la ambulancia</b>
     */

    public ThreadOperario(Operario operario, Ambulancia ambulancia) {
    	assert operario!=null && ambulancia!=null : "El operario o la ambulancia no pueden ser nulos.";
    	
        this.operario = operario;
        this.ambulancia = ambulancia;
    }

    /**
	 * Método run para el hilo cuando arranque su ejecución con start()
	 * Se encargará de ejecutar las solicitudes de mantenimiento del operario.
	 */
    @Override
    public void run() {
        ambulancia.arrancaAtencion();
        try {
                if (ambulancia.isSimulacion()){
                    try {
                        ambulancia.IrATaller();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    operario.notificarObservadores("Se ha iniciado el mantenimiento de la ambulancia. Tiempo de espera aproximado 5 segundos.");

                    try {
                        Thread.sleep(5000); // Simula el tiempo que tarda en realizar la tarea
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    operario.notificarObservadores("Se ha finalizado el mantenimiento de la ambulancia.");

                    ambulancia.finalizarMantenimiento();

                    try{
                        Thread.sleep(1000); // Simula el tiempo que tarda en regresar del taller.
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    ambulancia.solicitudRetorno();
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        ambulancia.terminaAtencion();
    }
}
