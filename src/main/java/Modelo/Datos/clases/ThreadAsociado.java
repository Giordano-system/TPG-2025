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
				ambulancia.solicitaAtencionADomicilio();
			else
				ambulancia.solicitaTrasladoAClinica();
			
			Thread.sleep(5000);	
		}
		
	}
	
	/**
	 * METODO DE LA AMBULANCIA
	 * Método sincronizado que se encarga de recibir las solicitudes (de tipo Atención a Domicilio) de los asociados,
	 * en caso de no poder satisfacerlas se queda en espera hasta que la ambulancia esté disponible (se duermen los hilos).
	 * <b>POST:</b> El estado de la ambulancia habrá cambiado.
	 */
	public synchronized void solicitaAtencionADomicilio() {
		System.out.println("Un asociado esta esperando ser atendido a domicilio."); // Luego cambiarlo por el patron Observer
		
		while(this.estado.getNombre() != "Disponible" && this.estado.getNombre() != "Regresando sin paciente")
			wait();
		
		this.atencionADomicilio();
		System.out.println("Un asociado esta siendo atendido a domicilio.");
	}
	
	/**
	 * METODO DE LA AMBULANCIA
	 * Método sincronizado que se encarga de recibir las solicitudes (de tipo Traslado a Clínica) de los asociados,
	 * en caso de no poder satisfacerlas se queda en espera hasta que la ambulancia esté disponible (se duermen los hilos).
	 * <b>POST:</b> El estado de la ambulancia habrá cambiado.
	 */
	public synchronized void solicitaTrasladoAClinica() {
		System.out.println("Un asociado esta esperando ser traslado a la clinica."); // Luego cambiarlo por el patron Observer
		
		while(this.estado.getNombre() != "Disponible" && this.estado.getNombre() != "Regresando sin paciente")
			wait();
		
		this.trasladoAClinica();
		System.out.println("Un asociado esta siendo trasladado a la clinica.");
	}
}
