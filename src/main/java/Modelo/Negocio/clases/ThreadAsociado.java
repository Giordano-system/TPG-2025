package Modelo.Negocio.clases;

import java.util.Random;

/**
 * Clase que representa a un Hilo de un Asociado.
 * Hereda de la clase Thread.
 * @author Grupo 9 - POO
 * @version 2.0
 */
public class ThreadAsociado extends Thread {

    private int solicitudes;
	private Asociado asociado;
	private Ambulancia ambulancia;
	
	/**
     * Constructor de la clase ThreadAsociado.
     * <b>Pre:</b> asociado != null, ambulancia != null, solicitudes => 0.
     * @param asociado Asociado que solicita la ambulancia.
     * @param ambulancia Ambulancia de la clínica, recurso compartido por los asociados.
     * @param solicitudes Cantidad de solicitudes que realizará el asociado.
     * <b>Post:</b> Se crea la instancia del ThreadAsociado con el asociado y la ambulancia pasada como parametro.
     */
	public ThreadAsociado(Asociado asociado, Ambulancia ambulancia, int solicitudes) {
		super();
		if (asociado == null || ambulancia == null) {
            assert (false) : "El asociado o la ambulancia no pueden ser nulos.";
        }
        this.asociado = asociado;
        this.ambulancia = ambulancia;
        this.solicitudes = solicitudes;
	}

	/**
	 * Método run para el hilo cuando arranque su ejecución con start()
	 * Se encargará de ejecutar todas las solicitudes que tenga el asociado.
     * <b>Post: El asociado termino de realizar todas sus peticiones a la ambulancia</b>
	 */
	@Override
	public void run() {
		try {
            int n = solicitudes;
            Random random = new Random();
            ambulancia.arrancaAtencion();
            int i=0;
            while(i<n && ambulancia.isSimulacion()) {

                int solicitud = random.nextInt(2) + 1;

                int tiempoDeEspera = random.nextInt(5000) + 1000;
                try {
                    Thread.sleep(tiempoDeEspera);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(solicitud == 1)
                    try {
                        ambulancia.solicitaAtencionADomicilio();
                        if (ambulancia.isSimulacion())
                            asociado.notificarObservadores("El asociado: " + asociado.getNombre() + " ha solicitado atención a domicilio.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                else
                    try {
                        ambulancia.solicitaTrasladoAClinica();
                        if (ambulancia.isSimulacion())
                            asociado.notificarObservadores("El asociado: " + asociado.getNombre() + " ha solicitado traslado a clínica.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                if (ambulancia.isSimulacion()){
                    tiempoDeEspera = random.nextInt(5000) + 1000;
                    try {
                        Thread.sleep(tiempoDeEspera);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
                ambulancia.solicitudRetorno();

                i++;
            }
            System.out.println("ThreadAsociado finalizado");
            if (ambulancia.isSimulacion()){
                ambulancia.terminaAtencion();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
