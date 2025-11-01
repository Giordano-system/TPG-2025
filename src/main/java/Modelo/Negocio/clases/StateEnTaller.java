package Modelo.Negocio.clases;

import Modelo.Negocio.interfaces.StateAmbulancia;
import Modelo.ModeloExcepciones.AccionImposibleException;

public class StateEnTaller implements StateAmbulancia {

    Ambulancia ambulancia;

    public StateEnTaller(Ambulancia ambulancia) {
        this.ambulancia = ambulancia;
    }

    @Override
    public void SolicitudAtencionDomicilio() {
        //NADA
    }

    @Override
    public void SolicitudTrasladoClinica() throws AccionImposibleException {
        throw new AccionImposibleException("Imposible realizar traslado, realizando mantenimiento");
    }

    @Override
    public void RetornoAutomaticoClinica() {
        //NADA
    }

    @Override
    public void SolicitudMantenimiento() {
        this.ambulancia.setEstado(new StateRegresandoTaller(this.ambulancia));
    }
    
    @Override
	public String getNombre() {
		return "En taller";
	}
}
