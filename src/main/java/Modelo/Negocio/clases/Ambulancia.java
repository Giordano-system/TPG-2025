package Modelo.Negocio.clases;

import java.util.Random;

import Modelo.Negocio.interfaces.StateAmbulancia;
import Patrones.Observer.IObservable;
import Patrones.Observer.IObservador;
import Patrones.Observer.Observable;

/**
 * Clase que representa una ambulancia en el sistema de gestión de emergencias médicas.
 * Implementa la interfaz IObservable para permitir la observación de cambios en su estado.
 * Utiliza el patrón de estado para manejar diferentes estados de la ambulancia.
 * @author Grupo 9 - POO
 * @version 2.0
 */

public class Ambulancia extends Observable implements IObservable {

    private StateAmbulancia estado;
    private boolean change = false;
    private boolean simulacion = true;
    private int contadorAtenciones = 0;

    public Ambulancia() {
        super();
        this.estado = new StateDisponible(this);
    }

    /**
     * Notifica a todos los observadores sobre un evento específico.
     * @param evento
     * <b>Post:</b> Todos los observadores habrán sido notificados del evento.
     */

    @Override
    public void notificarObservadores(String evento) {
        for (IObservador observador : this.observadores) {
            observador.update(this, evento);
        }
    }

    public StateAmbulancia getEstado() {
        return this.estado;
    }

    /**
     * Establece el estado actual de la ambulancia.
     * @param estado
     * <b>Post:</b> El estado de la ambulancia habrá sido actualizado y los observadores notificados.
     */
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
        notificarObservadores("Termino la simulacion");
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
        while (this.estado.getNombre() != "Disponible" && this.estado.getNombre() != "Regresando sin paciente"  && this.simulacion) {
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
        	if(this.estado.getNombre() == "En taller")
        		this.SolicitudMantenimiento();
    }
    
    /**
     * Metodo sincronizado que se encarga de retornar automaticamente la ambulancia a la clinica.
     * <b>Post:</b> El estado de la ambulancia habra cambiado.
     */

    public synchronized void solicitudRetorno() {
        this.RetornoAutomaticoClinica();
    }

    public void arrancaAtencion() {
    	contadorAtenciones++;
    }

    public void terminaAtencion() {
    	contadorAtenciones--;
        if (contadorAtenciones==0){
            this.simulacion = false;
            notificarObservadores("Termino la simulacion");
        }

    }

    public void setSimulacion(){
        	this.simulacion = true;
            contadorAtenciones = 0;
    }


}
