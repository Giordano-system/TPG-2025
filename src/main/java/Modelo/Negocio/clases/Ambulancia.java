package Modelo.Negocio.clases;

import java.util.Random;

import Modelo.Negocio.interfaces.StateAmbulancia;
import Patrones.Observer.IObservable;
import Patrones.Observer.IObservador;
import Patrones.Observer.Observable;

public class Ambulancia extends Observable implements IObservable {

    private StateAmbulancia estado;
    private boolean change = false;
    private boolean simulacion = true;
    

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
    
    public boolean isSimulacion() {
		return simulacion;
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
     * Método para finalizar la simulacion, notifica a todos los hilos para que terminen de ejecutarse.
     */

    public synchronized void finalizaSimulacion() {
    	this.simulacion = false;
    	notifyAll();
    }
    
    /**
	 * Método sincronizado que se encarga de recibir las solicitudes (de tipo Atención a Domicilio) de los asociados,
	 * en caso de no poder satisfacerlas se queda en espera hasta que la ambulancia esté disponible (se duermen los hilos).
	 * <b>POST:</b> El estado de la ambulancia habrá cambiado.
     * @throws InterruptedException 
	 */

	public synchronized void solicitaAtencionADomicilio() throws InterruptedException {
		while(this.estado.getNombre() != "Disponible" && this.estado.getNombre() != "Regresando sin paciente" && this.simulacion)
			wait();
		
		if(this.simulacion)
			this.SolicitudAtencionDomicilio();
		
	}
	
	/**
	 * Método sincronizado que se encarga de recibir las solicitudes (de tipo Traslado a Clínica) de los asociados,
	 * en caso de no poder satisfacerlas se queda en espera hasta que la ambulancia esté disponible (se duermen los hilos).
	 * <b>POST:</b> El estado de la ambulancia habrá cambiado.
	 * @throws InterruptedException 
	 */

	public synchronized void solicitaTrasladoAClinica() throws InterruptedException {
		while(this.estado.getNombre() != "Disponible" && this.estado.getNombre() != "Regresando sin paciente"  && this.simulacion)
			wait();
		
		if(this.simulacion)
			this.SolicitudTrasladoClinica();
	}

    /**
     * Metodo sincronizado que se encarga de llevar la ambulancia al taller de mantenimiento
     * en caso de no poder satisfacer la accion se queda en espera hasta que la ambulancia este disponible (se duermen los hilos).
     * <b>Post:</b> El estado de la ambulancia habra cambiado.
     */

    public synchronized void IrATaller() throws InterruptedException {
        while (this.estado.getNombre() != "Disponible" && this.simulacion) {
            wait();
        }
        if(this.simulacion)
        	this.SolicitudMantenimiento();
    }

    /**
     * Metodo sincronizado que se encarga de finalizar el mantenimiento.
     * <b>Post:</b> El estado de la ambulancia habra cambiado.
     */

    public synchronized void finalizarMantenimiento() {
        	this.SolicitudMantenimiento();
    }
    
    /**
     * Metodo sincronizado que se encarga de retornar automaticamente la ambulancia a la clinica.
     * <b>Post:</b> El estado de la ambulancia habra cambiado.
     */

    public synchronized void solicitudRetorno() {
        this.RetornoAutomaticoClinica();
    }
}
