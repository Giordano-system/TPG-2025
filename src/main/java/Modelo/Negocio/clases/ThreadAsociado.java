package Modelo.Negocio.clases;

import java.util.Random;

/**
 * Clase que representa a un Hilo de un Asociado.
 * Hereda de la clase Thread.
 * @author Grupo 9 - POO
 * @version 1.0
 */
public class ThreadAsociado extends Thread {

	private Asociado asociado;
	private Ambulancia ambulancia;
	
	/**
     * Constructor de la clase ThreadAsociado.
     * <b>Pre:</b> asociado != null, ambulancia != null
     * @param asociado Asociado que solicita la ambulancia.
     * @param ambulancia Ambulancia de la clínica, recurso compartido por los asociados.
     * <b>Post:</b> Se crea la instancia del ThreadAsociado con el asociado y la ambulancia pasada como parametro.
     */
	public ThreadAsociado(Asociado asociado, Ambulancia ambulancia) {
		super();
		if (asociado == null || ambulancia == null) {
            assert (false) : "El asociado o la ambulancia no pueden ser nulos.";
        }
        this.asociado = asociado;
        this.ambulancia = ambulancia;
	}

	/**
	 * Método run para el hilo cuando arranque su ejecución con start()
	 * Se encargará de ejecutar todas las solicitudes que tenga el asociado.
     * <b>Post: El asociado termino de realizar todas sus peticiones a la ambulancia</b>
	 */

	@Override
	public void run() {
		int n = this.asociado.getSolicitudes();
		Random random = new Random();
		
		for(int i=0; i<n; i++) {
			int solicitud = random.nextInt(2) + 1;
			
			if(solicitud == 1)
				try {
					ambulancia.solicitaAtencionADomicilio();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			else
				try {
					ambulancia.solicitaTrasladoAClinica();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			int tiempoDeEspera = random.nextInt(5000) + 1000;
			try {
				Thread.sleep(tiempoDeEspera);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		
	}
}
