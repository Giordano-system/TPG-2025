package Modelo.Negocio.clases;

import java.util.Random;

import Modelo.Negocio.interfaces.StateAmbulancia;
import Patrones.Observer.IObservable;
import Patrones.Observer.IObservador;
import Patrones.Observer.Observable;

public class Ambulancia extends Observable implements IObservable {

    private StateAmbulancia estado;
    private boolean change = false;

    public Ambulancia() {
        super();
        this.estado = new StateDisponible(this);
    }

    @Override
    public void notificarObservadores(String evento) {
        for (IObservador observador : this.observadores) {
            observador.update(this, "Ambulancia");
        }
    }

    public StateAmbulancia getEstado() {
        return this.estado;
    }

    public void setEstado(StateAmbulancia estado) {
        this.estado = estado;
        setChanged();
        notificarObservadores("Cambio de estado");
    }

    public void setChanged() {
    	this.change = true;
    }

    public void clearChanged() {
    	this.change = false;
    }

    public boolean getChange() {
        return this.change;
    }
    
    public void SolicitudAtencionDomicilio() {
    	this.estado.SolicitudAtencionDomicilio();
    }

    public void SolicitudTrasladoClinica() {
    	this.estado.SolicitudTrasladoClinica();
    }

    public void RetornoAutomaticoClinica() {
    	this.estado.RetornoAutomaticoClinica();
    	notifyAll();
    }

    public void SolicitudMantenimiento() {
    	this.estado.SolicitudMantenimiento();
    }
    
    /**
	 * Método sincronizado que se encarga de recibir las solicitudes (de tipo Atención a Domicilio) de los asociados,
	 * en caso de no poder satisfacerlas se queda en espera hasta que la ambulancia esté disponible (se duermen los hilos).
	 * <b>POST:</b> El estado de la ambulancia habrá cambiado.
     * @throws InterruptedException 
	 */
	public synchronized void solicitaAtencionADomicilio() throws InterruptedException {
		while(this.estado.getNombre() != "Disponible" && this.estado.getNombre() != "Regresando sin paciente")
			wait();
		
		this.SolicitudAtencionDomicilio();
		
		Random random = new Random();
		int tiempoDeEspera = random.nextInt(5000) + 1000;
		
		Thread.sleep(tiempoDeEspera);
		
		this.RetornoAutomaticoClinica();
	}
	
	/**
	 * Método sincronizado que se encarga de recibir las solicitudes (de tipo Traslado a Clínica) de los asociados,
	 * en caso de no poder satisfacerlas se queda en espera hasta que la ambulancia esté disponible (se duermen los hilos).
	 * <b>POST:</b> El estado de la ambulancia habrá cambiado.
	 * @throws InterruptedException 
	 */

	public synchronized void solicitaTrasladoAClinica() throws InterruptedException {
		while(this.estado.getNombre() != "Disponible" && this.estado.getNombre() != "Regresando sin paciente")
			wait();
		
		this.SolicitudTrasladoClinica();
		
		Random random = new Random();
		int tiempoDeEspera = random.nextInt(5000) + 1000;
		
		Thread.sleep(tiempoDeEspera);
		
		this.RetornoAutomaticoClinica();
	}

    /**
     * Metodo sincronizado que se encarga de llevar la ambulancia al taller de mantenimiento
     * en caso de no poder satisfacer la accion se queda en espera hasta que la ambulancia este disponible (se duermen los hilos).
     * <b>Post:</b> El estado de la ambulancia habra cambiado.
     */

    public synchronized void IrATaller() throws InterruptedException {
        while (this.estado.getNombre() != "Disponible") {
            wait();
        }
        this.SolicitudMantenimiento();
    }

    public synchronized void finalizarMantenimiento() {
        this.SolicitudMantenimiento();
        try{
            Thread.sleep(3000); // Simula el tiempo que tarda en volver a la clinica desde el taller
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    	this.RetornoAutomaticoClinica();
    }

}
