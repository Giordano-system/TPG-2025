package Modelo.Datos.clases;

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
     * <b>PRE:</b> asociado != null, ambulancia != null
     * @param asociado Asociado que solicita la ambulancia.
     * @param ambulancia Ambulancia de la clínica, recurso compartido por los asociados.
     */
	public ThreadAsociado(Asociado asociado, Ambulancia ambulancia) {
		super();
		this.asociado = asociado;
		this.ambulancia = ambulancia;
	}

	/**
	 * Método run para el hilo cuando arranque su ejecución con start()
	 * Se encargará de ejecutar todas las solicitudes que tenga el asociado. 
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
