package Modelo.Negocio.clases;

import Modelo.Negocio.interfaces.StateAmbulancia;
import Modelo.ModeloExcepciones.AccionImposibleException;

public class StateRegresandoTaller implements StateAmbulancia {

    Ambulancia ambulancia;

    public StateRegresandoTaller(Ambulancia ambulancia) {
        this.ambulancia = ambulancia;
    }

    @Override
    public void SolicitudAtencionDomicilio() {
        //NADA
    }

    @Override
    public void SolicitudTrasladoClinica() throws AccionImposibleException {
        throw new AccionImposibleException("Imposible realizar traslado a clinica, regresando de mantenimiento");
    }

    @Override
    public void RetornoAutomaticoClinica() {
        this.ambulancia.setEstado(new StateDisponible(this.ambulancia));
    }

    @Override
    public void SolicitudMantenimiento() throws AccionImposibleException {
        throw new AccionImposibleException("Imposible realizar mantenimiento, regresando de mantenimiento");
    }
    
    @Override
	public String getNombre() {
		return "Regresando del taller";
	}
}
