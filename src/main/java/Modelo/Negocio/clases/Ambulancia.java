package Modelo.Negocio.clases;

import java.util.Random;

import Modelo.Negocio.interfaces.StateAmbulancia;
import Patrones.Observer.IObservador;
import Patrones.Observer.Observable;

public class Ambulancia extends Observable {

    private StateAmbulancia estado;
    private boolean change = false;

    public Ambulancia() {
        super();
        this.estado = new StateDisponible(this);
    }

    @Override
    public void notificarObservadores() {
        for (IObservador observador : this.observadores) {
            observador.update(this, "CambioEstadoAmbulancia");
        }
    }

    public StateAmbulancia getEstado() {
        return this.estado;
    }

    public void setEstado(StateAmbulancia estado) {
        this.estado = estado;
        setChanged();
        notificarObservadores();
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
		System.out.println("Un asociado esta esperando ser atendido a domicilio."); // Luego cambiarlo por el patron Observer
		
		while(this.estado.getNombre() != "Disponible" && this.estado.getNombre() != "Regresando sin paciente")
			wait();
		
		this.SolicitudAtencionDomicilio();
		System.out.println("Un asociado esta siendo atendido a domicilio.");
		
		Random random = new Random();
		int tiempoDeEspera = random.nextInt(5000) + 1000;
		
		Thread.sleep(tiempoDeEspera);
		
		System.out.println("La ambulancia retorna a la clinica.");
		this.RetornoAutomaticoClinica();
	}
	
	/**
	 * Método sincronizado que se encarga de recibir las solicitudes (de tipo Traslado a Clínica) de los asociados,
	 * en caso de no poder satisfacerlas se queda en espera hasta que la ambulancia esté disponible (se duermen los hilos).
	 * <b>POST:</b> El estado de la ambulancia habrá cambiado.
	 * @throws InterruptedException 
	 */
	public synchronized void solicitaTrasladoAClinica() throws InterruptedException {
		System.out.println("Un asociado esta esperando ser traslado a la clinica."); // Luego cambiarlo por el patron Observer
		
		while(this.estado.getNombre() != "Disponible" && this.estado.getNombre() != "Regresando sin paciente")
			wait();
		
		this.SolicitudTrasladoClinica();
		System.out.println("Un asociado esta siendo trasladado a la clinica.");
		
		Random random = new Random();
		int tiempoDeEspera = random.nextInt(5000) + 1000;
		
		Thread.sleep(tiempoDeEspera);
		
		System.out.println("La ambulancia retorna a la clinica.");
		this.RetornoAutomaticoClinica();
	}
}
