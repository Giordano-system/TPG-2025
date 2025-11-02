package Modelo.Negocio.clases;

public class ThreadOperario implements Runnable {

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
        for (int i = 0; i < 3; i++) {
            try{
                ambulancia.IrATaller();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            try {
                Thread.sleep(5000); // Simula el tiempo que tarda en realizar la tarea
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            ambulancia.finalizarMantenimiento();
        }
    }

}
