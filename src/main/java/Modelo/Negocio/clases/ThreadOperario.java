package Modelo.Negocio.clases;

import java.util.Random;

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
        if (operario == null || ambulancia == null) {
            assert (false) : "El operario o la ambulancia no pueden ser nulos.";
        }
        this.operario = operario;
        this.ambulancia = ambulancia;
    }

    @Override
    public void run() {

        try {
            Random r = new Random();
            for (int i = 0; i < 3; i++) {
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
                ambulancia.finalizarMantenimiento();
                try {
                    Thread.sleep(r.nextInt(5000) + 2000); // Espera entre 2 y 7 segundos antes de iniciar el siguiente mantenimiento
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
